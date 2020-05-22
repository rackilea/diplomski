public class WatchServiceMonitor implements Monitor, Runnable, Closeable {
    private static Logger log = LoggerFactory.getLogger( WatchServiceMonitor.class.getName() );
    private Destination destination;
    private Path hotFolder;
    private Thread thread;

    public WatchServiceMonitor( Path hotFolder, Destination destination ) {
        this.hotFolder = hotFolder;
        this.destination = destination;

    }

    @Override
    public void close() throws IOException {
        try {
            stop();
        }
        catch ( InterruptedException e ) {
            log.warn( "request to stop failed, guess its time to stop being polite!" );
        }
    }

    @Override
    public void join() throws InterruptedException {
        thread.join();
    }

    @Override
    public void run() {
        try (WatchService watcher = FileSystems.getDefault().newWatchService()) {
            if ( log.isTraceEnabled() ) log.trace( "registering create watcher on " + hotFolder.toAbsolutePath().toString() );
            hotFolder.register( watcher, StandardWatchEventKinds.ENTRY_CREATE );
            if ( log.isDebugEnabled() ) log.debug( "watcher registration complete for " + hotFolder.toAbsolutePath().toString() );
            synchronized ( this ) {
                this.notifyAll();
            }
            for ( ;; ) {
                if ( thread.isInterrupted() ) break;

                WatchKey key = null;
                try {
                    log.trace( "waiting for create event" );
                    key = watcher.take();
                    log.trace( "got an event, process it" );
                }
                catch ( InterruptedException ie ) {
                    log.trace( "interruped, must be time to shut down..." );
                    break;
                }

                for ( WatchEvent<?> eventUnknown : key.pollEvents() ) {
                    WatchEvent.Kind<?> kind = eventUnknown.kind();

                    if ( kind == StandardWatchEventKinds.OVERFLOW ) return;

                    @SuppressWarnings( "unchecked" )
                    WatchEvent<Path> eventPath = (WatchEvent<Path>) eventUnknown;
                    Path path = hotFolder.resolve( eventPath.context() );
                    log.trace( "calling destination.transfer({})", path );
                    destination.transfer( path );
                    log.info( "transferred {} to destination" );

                    if (! key.reset()) {
                        break;
                    }
                }
            }
        }
        catch ( IOException ioe ) {
            log.error( ioe.getMessage(), ioe );
        }
        log.debug( "existing run loop" );
    }

    @Override
    public void start() throws InterruptedException {
        log.trace( "starting monitor" );
        thread = new Thread( this );
        thread.start();
        synchronized ( this ) {
            this.wait();
        }
        log.trace( "monitor started" );
    }

    @Override
    public void stop() throws InterruptedException {
        log.trace( "stopping monitor" );
        thread.interrupt();
        thread.join();
        thread = null;
        log.trace( "monitor stopped" );
    }
}
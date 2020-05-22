public class FileWatchService implements Runnable {
    private final org.apache.logging.log4j.Logger logger = LogManager.getLogger(FileWatchService.class);
    private WatchService watchService = null;
    private Map<WatchKey,Path> keys = null;
    private String tempPath;


    public FileWatchService(String tempPath) {
        try {
            this.watchService = FileSystems.getDefault().newWatchService();
            this.keys = new HashMap<WatchKey,Path>();
            this.tempPath = tempPath;
            Path path = Paths.get(tempPath);
            register(path);
            logger.info("Watch service has been initiated.");
        }
        catch (Exception e) {
            logger.error("The error occurred in process of registering watch service", e);
        }
    }

    // Method which register folder to watch service.
    private void register(Path tempPath) throws IOException {
        logger.debug("Registering folder {} for watching.", tempPath.getFileName());
        // Registering only for delete events.
        WatchKey key = tempPath.register(watchService, ENTRY_DELETE);
        keys.put(key, tempPath);
    }

    @Override
    public void run() {
        try {
            Thread.currentThread().setName("FileWatchService");
            this.processEvents();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void processEvents() throws InterruptedException {
            WatchKey key;

            // Waiting until event occur.
            while ((key = watchService.take()) != null) {
                // Poll all events when event occur.
                for (WatchEvent<?> event : key.pollEvents()) {
                    // Getting type of event - delete, modify or create.
                    WatchEvent.Kind kind = event.kind();

                    // We are interested only for delete events.
                    if (kind == ENTRY_DELETE) {
                        // Sending "notification" to appender watcher service.
                        logger.debug("Received event about file deletion. File: {}", event.context());
                        AppenderWatcher.hadleLogFileDeletionEvent(this.tempPath + event.context());
                    }
                }
                key.reset();
            }
    }
}
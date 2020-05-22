public class FileMonitorServletContextListener implements
        ServletContextListener {

    public interface FileMonitor {

        void start(String fromFolder, String toFolder);

        void stop();

    }

    public class SimpleThreadedWatcher implements FileMonitor {

        private class SimpleThread extends Thread {

            private boolean running = true;
            private String fromFolder;
            private String toFolder;

            public SimpleThread(String fromFolder, String toFolder) {
                this.fromFolder = fromFolder;
                this.toFolder = toFolder;
            }

            private void copy(Path child, String toFolder) {
                // Copy the file to the folder
            }

            @Override
            public void run() {
                try {
                    WatchService watcher = FileSystems.getDefault()
                            .newWatchService();
                    Path fromPath = Paths.get(fromFolder);
                    watcher = FileSystems.getDefault().newWatchService();

                    WatchKey key = fromPath.register(watcher,
                            StandardWatchEventKinds.ENTRY_CREATE);

                    while (running) {

                        for (WatchEvent<?> event : key.pollEvents()) {
                            // Context for directory entry event is the file
                            // name of
                            // entry
                            @SuppressWarnings("unchecked")
                            WatchEvent<Path> ev = (WatchEvent<Path>) event;

                            Path name = ev.context();
                            Path child = fromPath.resolve(name);

                            // print out event
                            System.out.format("%s: %s\n", event.kind().name(),
                                    child);

                            copy(child, toFolder);

                            boolean valid = key.reset();
                            if (!valid) {
                                break;
                            }
                        }

                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Error: ", e);
                }
            }

            public void stopWorking() {
                running = false;
            }

        }

        private SimpleThread worker;

        @Override
        public void start(String fromFolder, String toFolder) {
            worker = new SimpleThread(fromFolder, toFolder);
            worker.start();
        }

        @Override
        public void stop() {
            worker.stopWorking();
        }

    }

    FileMonitor fileMonitor = new SimpleThreadedWatcher();

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        fileMonitor.stop();
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        fileMonitor.start("FROM", "TO");
    }

}
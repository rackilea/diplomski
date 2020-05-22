// Adding directory listener
        WatchService watcher = FileSystems.getDefault().newWatchService();
        Path tempPath = Paths.get("C:\\xampp\\htdocs\\someDirectory");
        tempPath.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY);


while (true) {
                WatchKey key = watcher.take();

                // Poll all the events queued for the key.
                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind kind = event.kind();
                    if (kind.name().endsWith("ENTRY_CREATE")) {
                        // Do something  
                    }
                }
}
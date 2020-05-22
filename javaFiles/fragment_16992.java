public static void main(String[] args) throws Exception {
    Path myDir = Paths.get("C:/file_dir/listen_to_this");

    WatchService watcher = myDir.getFileSystem().newWatchService();
    myDir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

    while (true) {
        WatchKey watckKey = watcher.take();
        List<WatchEvent<?>> events = watckKey.pollEvents();
        for (WatchEvent event : events) {
            if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                System.out.println("Created: " + event.context().toString());
            }
            if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                System.out.println("Delete: " + event.context().toString());
            }
            if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                System.out.println("Modify: " + event.context().toString());
            }
        }
        watchKey.reset();
    }
}
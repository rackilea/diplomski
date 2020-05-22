final String filePath = ...
final String searchIndex = ...
Executor background = Executors.newSingleThreadExecutor();
Runnable mylookupThread = new Runnable() {
    public void run() { MainWindow.this.processFile(filePath);
        Thread t = new Thread(new lookupThread(MainWindow.arrFile, true, false, searchIndex));
        t.setName("Lookup");
        t.setPriority(10);
        t.start();
    }
};
background.execute(mylookupThread);
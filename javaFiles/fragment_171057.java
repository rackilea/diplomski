public synchronized void enqueueDownload(final DownloadTask task) {
    SomethingHandler handler = new SomethingHandler() {
        @Override public void handleSomething() {
            // This would not compile if task were not final
            task.doSomething();
        }
    };
    // Use handler
}
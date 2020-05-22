class LookupTask implements Runnable {
    private final String filePath, searchIndex;
    LookupTask(String filePath, String searchIndex) {
       this.filePath = filePath;
       this.searchIndex = searchIndex;
    }

    public void run() { ... } 
}
...
background.execute(new LookupTask(filePath, searchIndex));
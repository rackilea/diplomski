FileAlterationMonitor monitor = new FileAlterationMonitor(directory) {
    @Override
    public void run () {
        //setting name
        Thread.currentThread().setName("monitorThread");
        this.run();
    }
}
FolderScan(String path, BlockingQueue<File> queue, CountDownLatch latch,
        File endOfWorkFile, List<Checker> checkers) {
    this.path = path;
    this.queue = queue;
    this.latch = latch;
    this.endOfWorkFile = endOfWorkFile;
    this.checkers = checkers;
}
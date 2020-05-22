public void run() {
    // make our permanent ftp instance
    this._ftp = new FTPClient();
    // connect it for the life of this thread
    this._connect();
    try {
        // loop getting tasks until we are interrupted
        // could also use volatile boolean !shutdown
        while (!Thread.currentThread().isInterrupted()) {
            FtpTask task = taskQueue.take();
            // if you are using a poison pill
            if (task == SHUTDOWN_TASK) {
                break;
            }
            // do the download here
            download(task.base, task.path, task.file);
        }
    } finally {
        this._disconnect();
    }
}
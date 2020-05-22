for (int i = 0; i < 4; i++) {
    workerpool.execute(new Runnable() {
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                process(inputQueue.take());
            }
        }
    });
}
// remember to shut the queue down after you've submitted the last job
workerpool.shutdown();
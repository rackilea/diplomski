class Worker implements Runnable {
    public void run() {
        while (true) {
            LME item = null;
            try {
                item = queueOfLme.take()
            } catch (InterruptedException e) {
                break;
            }
            /* do work */
        }
    }
}
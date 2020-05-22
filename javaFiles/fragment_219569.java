new Thread() {
    public void run() {
        while (true) {
            try { Thread.sleep(numMinutes * 60 * 1000); }
            catch (InterruptedException ex) { }
            logHistogramInfo();
        }
    }
};
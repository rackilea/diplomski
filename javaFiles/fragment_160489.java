class Download extends SwingWorker<Void, Void> implements Serializable, Runnable {

    private static final long SLEEP_TIME = 200;

    public Void doInBackground() throws Exception {
        int myProgress = 0;
        while (myProgress < 100) {
            myProgress += (int) (10 * Math.random());
            myProgress = Math.min(myProgress, 100);
            setProgress(myProgress);
            Thread.sleep(SLEEP_TIME);
        }
        return null;
    }

}
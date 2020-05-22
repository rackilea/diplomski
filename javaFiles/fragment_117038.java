class FirstCountDown extends SwingWorker<Integer, Integer> {

    private _suspended = false;

    public synchronized void suspend() { _suspended = true; notify(); }
    public synchronized void resume() { _suspended = false; notify(); }

    public Integer doInBackground() {
        for(int i=0; i<1000; i++) {
            synchronized(this) {
                while (_suspended) {
                    wait(); // The current thread will block until some else calls notify()
                            // Then if _suspended is false, it keeps looping the for
                }
            }
            CountDown.count1.setText(String.valueOf(1000-i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } 
        return null;
    }
}
private static boolean done = false;

Activity_Splash.this.runOnUiThread(new Runnable() {
    @Override
    public void run() {
        setMetrics();
        final Timer t=new Timer();
        t.schedule(new TimerTask() {
        @Override
        public void run() {
        if(done){
        deleteMetrics();
        t.cancel();
        t.purge();
        }
        }
     }, 1000);

    }
});
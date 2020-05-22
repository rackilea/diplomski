Timer timer = new Timer( );
timer.schedule(new TimerTask() {
    @Override
    public void run() {
        getit(savedInstanceState);
    }
}, Long.parseLong(setcas));
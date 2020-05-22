class activity extends TimerTask { 
    private long milis;
    public activity(long milis) {
        this.milis = milis;
    }
    public void run() {
        function(args)
        if(condition(args)) {timer.cancel();}
    }
}
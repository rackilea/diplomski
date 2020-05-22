int hour = 1000*60*60;
int delay = 0;
Timer t = new Timer();

t.scheduleAtFixedRate(new TimerTask() {
    public void run() {
        // Write to disk ...
    }
}, delay, hour);
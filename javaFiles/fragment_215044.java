t.scheduleAtFixedRate(new TimerTask() {
    @Override
    public void run() {
        if (playing) {
            // play sound
        }
    }
}, 0, rate);
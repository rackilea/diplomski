Timer timer = new Timer();
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            myMethod();
        }
}, 0);
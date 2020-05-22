task = new TimerTask() {
        private final int MAX_SECONDS = 100;

        @Override
        public void run() { 
            if (seconds < MAX_SECONDS) {
                System.out.println("Seconds = " + seconds);
                seconds++;
            } else {
                // stop the timer
                cancel();
            }
        }
    };
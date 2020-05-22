task = new TimerTask() {
        @Override
        public void run() { 
            while (seconds < 100) {
                System.out.println("Seconds = " + seconds);
                seconds++;
            }
        }
    };
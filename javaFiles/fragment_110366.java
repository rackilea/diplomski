Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
          //Call your method
          LoadCurrentTime()
        }
    },0, 2000);
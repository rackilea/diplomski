Timer timer = new Timer();

    TimerTask task = new TimerTask(){
        private int i = 0;
        public void run(){
            if (i <= 30) {
                lblTimer.setText("" + i++);
            }
        }
    };
    timer.scheduleAtFixedRate(task, 0, 1000); //1000ms = 1sec
Timer t = new Timer("Sceenshot timer");
    TimerTask screenShotTask  = new TimerTask() {
        @Override
        public void run() {
            // Call your code
        }
    };
    t.schedule(screenShotTask, 1000);
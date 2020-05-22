private void onTimer() {
    timer = new Timer();
    timer.schedule(new TimerTask() {

        @Override
        public void run() {
             load(); // Call the containing class method
        }
    }, TTL * 60000);
}
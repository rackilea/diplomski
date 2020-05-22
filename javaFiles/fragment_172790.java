public static void main(String[] args) throws Exception {
    Timer timer = new Timer();
    final TimerTask runUntilCancelledTask = new TimerTask() {
        @Override
        public void run() {
            System.out.println(new Date());
        }
    };
    timer.schedule(runUntilCancelledTask, 0, 1000);
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            runUntilCancelledTask.cancel();
        }
    }, 10000); // Run once after delay to cancel the first task
}
if(selectedOption == 1){
    Timer t = new Timer();
    t.schedule(new TimerTask() {
        @Override
        public void run() {
            System.out.println("Standby mode is enabled.");
        }
    }, 0, 300000);
} else {
    System.out.println("Standby mode is disabled.");
}
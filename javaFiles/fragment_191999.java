public class TimerClass {
    // don't make this static
    // otherwise you won't be able to use multiple instances at the same time
    volatile int secondsPassed = 0; 

    private final Controller controller;


    public TimerClass(Controller controller) {
        this.controller = controller;
    }

    TimerTask timerTask = new TimerTask() {

        @Override
        public void run() {
            secondsPassed++;
            // update on the JavaFX application thread
            Platform.runLater(() -> controller.setLblTime(secondsPassed));
        }
    };

    public void timerStart() {
        mytimer.scheduleAtFixedRate(timerTask, 1000, 1000);
    }

    public void timerPause() {
        mytimer.cancel();
    }

    public int getSecondsPassed() {
        return secondsPassed;
    }

}
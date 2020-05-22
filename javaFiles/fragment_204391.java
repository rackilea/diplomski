public class MyScreen extends MainScreen {
    private Timer mTimer;
    public MyScreen() {        
        mTimer = new Timer();
        //start after 1 second, repeat every 5 second
        mTimer.schedule(mTimerTask, 0, 5000);
    }

    TimerTask mTimerTask = new TimerTask() {
        public void run() {
            // some processing here
        }
    };
}
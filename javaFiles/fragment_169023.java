public class Refre
{
    final Timer timers = new Timer();
    final Handler handler = new Handler(); 
    private TimerTask task;

    public void trig(){
        task = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        new activityIns().execute();
                    }
                });
            }
        };       

        timers.schedule(task, 1000, 10000);
    }

    public void cancelTask() {
        timers.cancel(); // assuming http://developer.android.com/reference/java/util/Timer.html
    }
}
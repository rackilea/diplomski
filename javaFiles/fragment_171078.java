public class TimerHelper extends TimerTask {


Callable<Void> task;
private Timer timer;
long delay;

public TimerHelper(Callable<Void> task) {
    timer = new Timer();
    delay = 500;
    this.task = task;
    run();
}

@Override
public void run() {

    if (delay < 3600000) {

        try {
            task.call();
            timer.cancel();
        } catch (Exception e) {
            delay = delay + delay;
            timer.schedule(new TimerHelper(task), delay);
        }
    } else {
        try {
            timer.cancel();
        } catch (TimeLimitExceededException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
  }

}
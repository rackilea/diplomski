public interface TimeSource {
    long currentTimeMillis();
}

public class AlternateTimeSource implements TimeSource {

    long currentTime = 0;       

    public AlternateTimeSource() {
    }

    public setTime(long time) {
        if (time > currentTime) currentTime = time;
    }

    @Override
    public long currentTimeMillis() {
        return currentTime;
    }
}

public class SystemTimeSource implements TimeSource {

    @Override
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}

class SourcedTimerThread extends Thread {

    TimeSource reference_;
    TimerTask task_;
    long period_;
    long executionTime_;
    boolean done = false;

    SourcedTimerThread(TimeSource reference,TimerTask task,long delay,long period) {
        reference_     = reference;
        task_          = task;
        period_        = period >= 0 ? period : 0;
        executionTime_ = reference_.currentTimeMillis() + (delay >= 0 ? delay : 0);
        setName("SourcedTimerThread_"+reference_.getClass().getSimpleName());
        start();
    }

    public void cancel() {
        done = true;
        interrupt();
    }

    public void run() {

        long currentTime;

        while (!done) {
            try {
                currentTime = reference_.currentTimeMillis();
                if (executionTime_>currentTime) { 
                    // Task hasn't yet fired; wait
                    sleep(1);                   }
                else {
                    task_.run();
                    if (period_ > 0) {
                        // Repeating task, reschedule
                        executionTime_ = ((period_ < 0) ? currentTime-period_ : executionTime_ + period_);
                    }
                    else {
                        // Non-repeating task, done
                        break;
                    }
                }
            } catch (InterruptedException e) {
            }
        }
    }
}
import java.util.Timer;
import java.util.TimerTask;

public class CountdownText {

    Timer tmrTicks = new Timer();
    int secondsLeft = 0;
    int numberOfSecondsToCountdown = 0;
    boolean isWorking = false;
    private CountdownTextTickListener listener = null;

    public boolean getIsWorking(){
        return isWorking;
    }

    public CountdownText(int seconds) {
        if (secondsLeft < 0) secondsLeft = 0; 
        numberOfSecondsToCountdown = seconds;
        secondsLeft = seconds;
    }

    void startTimer() {
        isWorking = true;
        fireEvent(secondsLeft, false);
        tmrTicks = new Timer();
        tmrTicks.scheduleAtFixedRate( new TimerTask(){
            @Override
            public void run(){
                tickTimer();
            }
        }, 1000, 1000); 
    }

    private void stopTimer() {
        isWorking = false;
        tmrTicks.cancel();
    }

    private void tickTimer() {
         secondsLeft--;
         if (secondsLeft >= 1) 
         {
             fireEvent(secondsLeft, false);
         }
         else
         {
             Stop();
             fireEvent(secondsLeft, true);
         }
    }

    public void Reset() {
        Stop();
        secondsLeft = numberOfSecondsToCountdown;
        fireEvent(secondsLeft, false);
    }

    public void Stop() {
        stopTimer();
    }

    public void Start() {
        if (secondsLeft <= 0)
        {
            secondsLeft = 0;
            fireEvent(secondsLeft, true);
        }
        else
        {
            startTimer();
        }
    }

    protected void fireEvent(int seconds, boolean isStoppedState) {
        if (listener != null) {
            Object sender = this; 
            CountdownTextTickEventArgs eventArgs = new CountdownTextTickEventArgs(seconds, isStoppedState);
            listener.CountdownTextTickEventFired(sender, eventArgs);
        }
    }

    public void setListener(CountdownTextTickListener listener) {
        this.listener = listener;
    }
}
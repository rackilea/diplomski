import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Handler;
import android.os.Message;

public class SystemTimerAndroid {
    private final Timer clockTimer;

    private class Task extends TimerTask {
        public void run() {
            timerHandler.sendEmptyMessage(0);
        }
    }

    private final Handler timerHandler = new Handler() {
        public void handleMessage (Message  msg) {
            // runs in context of the main thread
            timerSignal();
        }
    };

    private List<SystemTimerListener> clockListener = new ArrayList<SystemTimerListener>();

    public SystemTimerAndroid() {
        clockTimer = new Timer();
        clockTimer.schedule(new Task(), 1000, 1000);
    }

    private void timerSignal() {
        for(SystemTimerListener listener : clockListener)
            listener.onSystemTimeSignal();      
    }

    public void killTimer() {
        clockTimer.cancel();
    }

    @Override
    public void addListener(SystemTimerListener listener) {
        clockListener.add(listener);        
    }
}
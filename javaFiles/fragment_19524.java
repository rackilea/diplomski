import java.util.Timer;
import java.util.TimerTask;

// from constructor, shown here out of place
timer = new Timer();

// and in method, again, shown out of place:
        INTERVAL_MILLISECONDS = (int)((double)(bufSize) / (double)(nativeSampleRate * 2) * 1000);
        timer.scheduleAtFixedRate( new TimerTask() {
                public void run() {
                        synchronized(this){
                                track.write(data, 0, bufSize);
                                track.play();
                        }
                }
        }, 0, INTERVAL_MILLISECONDS);
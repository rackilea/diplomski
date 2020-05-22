import java.applet.Applet;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Moves the mouse cursor once in a minute to prevent the screen saver from
 * kicking in.
 */
public class ScreenSaverDisablerApplet extends Applet {

    private static final int PERIOD = 59;
    private Timer screenSaverDisabler;

    @Override
    public void start() {
        screenSaverDisabler = new Timer();
        screenSaverDisabler.scheduleAtFixedRate(new TimerTask() {
            Robot r = null;
            {
                try {
                    r = new Robot();
                } catch (AWTException headlessEnvironmentException) {
                    screenSaverDisabler.cancel();
                }
            }
            @Override
            public void run() {
                Point loc = MouseInfo.getPointerInfo().getLocation();
                r.mouseMove(loc.x + 1, loc.y);
                r.mouseMove(loc.x, loc.y);
            }
        }, 0, PERIOD*1000);
    }

    @Override
    public void stop() {
        screenSaverDisabler.cancel();
    }

}
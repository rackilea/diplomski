/**
 * Set the volume to a value between 0 and 1.
 */
public void setVolume(double value) {
    // value is between 0 and 1
    value = (value<=0.0)? 0.0001 : ((value>1.0)? 1.0 : value);
    try {
        float dB = (float)(Math.log(value)/Math.log(10.0)*20.0);
        gainControl.setValue(dB);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}


/**
 * Fade the volume to a new value.  To shift volume while sound is playing,
 * ie. to simulate motion to or from an object, the volume has to change
 * smoothly in a short period of time.  Unfortunately this makes an annoying
 * clicking noise, mostly noticeable in the browser.  I reduce the click
 * by fading the volume in small increments with delays in between.  This
 * means that you can't change the volume very quickly.  The fade has to
 * to take a second or two to prevent clicks.
 */
float currDB = 0F;
float targetDB = 0F;
float fadePerStep = .1F;   // .1 works for applets, 1 is okay for apps
boolean fading = false;

public void shiftVolumeTo(double value) {
    // value is between 0 and 1
    value = (value<=0.0)? 0.0001 : ((value>1.0)? 1.0 : value);
    targetDB = (float)(Math.log(value)/Math.log(10.0)*20.0);
    if (!fading) {
        Thread t = new Thread(this);  // start a thread to fade volume
        t.start();  // calls run() below
    }
}

/**
 * Run by thread, this will step the volume up or down to a target level.
 * Applets need fadePerStep=.1 to minimize clicks.
 * Apps can get away with fadePerStep=1.0 for a faster fade with no clicks.
 */
public void run()
{
    fading = true;   // prevent running twice on same sound
    if (currDB > targetDB) {
        while (currDB > targetDB) {
            currDB -= fadePerStep;
            gainControl.setValue(currDB);
            try {Thread.sleep(10);} catch (Exception e) {}
        }
    }
    else if (currDB < targetDB) {
        while (currDB < targetDB) {
            currDB += fadePerStep;
            gainControl.setValue(currDB);
            try {Thread.sleep(10);} catch (Exception e) {}
        }
    }
    fading = false;
    currDB = targetDB;  // now sound is at this volume level
}
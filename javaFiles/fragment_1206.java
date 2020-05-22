package music;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

public class audiostream implements BasicPlayerListener, Runnable {

    public String streamurl;
    public BasicController playerControl;
    private volatile boolean shouldPlay = true;

    @Override
    public void run() {
        while (true) {
            if (shouldPlay) {
                player();
            }
        }
    }

    // ** RUN ONCE TO START THREAD
    public void start() {

        new Thread(this).start();

    }

    // ** RUN TO PAUSE/STOP THE PLAYER
    public void pause() {

        // set play bool to false
        shouldPlay = false;


        // stop player
        try {
            playerControl.stop();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(audiostream.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // ** RUN TO PLAY
    public void play() {
        shouldPlay = true;
    }


    // construct
    public audiostream(String givenStreamurl) {

        // assign the radio url
        streamurl = givenStreamurl;

    }

    // OPENS UP THE SHOUTCAST STREAM
    public void player() {

        // dont allow multiple runnings of this
        shouldPlay = false;

        // start stream
        try {
            BasicPlayer player = new BasicPlayer();
            playerControl = (BasicController) player;
            player.addBasicPlayerListener(this);
            try {
                playerControl.open(new URL(streamurl));
            } catch (MalformedURLException ex) { }
            playerControl.play();
        } catch (BasicPlayerException ex) { }

    }

    @Override
    public void opened(Object o, Map map) {
        //System.out.println("opened : "+map.toString());
    }

    @Override
    public void progress(int i, long l, byte[] bytes, Map map) {
        //System.out.println("opened : "+map.toString());
    }

    @Override
    public void stateUpdated(BasicPlayerEvent bpe) {
        //System.out.println("opened : "+bpe.toString());
    }

    @Override
    public void setController(BasicController bc) {
        //System.out.println("opened : "+bc.toString());
    }



}
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;

public class BackgroundMusicPlayer {

    private static MediaPlayer mp = null;

    private static int playingResId;

    public static boolean isSoundTurnedOff;

    private static boolean isPaused;

    /** Stop old sound and start new one */
    public static void play(Context context, int resIdToPlay) {

        if (isSoundTurnedOff || context==null)
            return;

        if (mp != null && playingResId==resIdToPlay) {
            if (isPaused)
                mp.start();
            isPaused = false;
            return;
        }

        stop();

        Intent i = new Intent("com.android.music.musicservicecommand");
        i.putExtra("command", "pause");
        context.sendBroadcast(i);

        playingResId = resIdToPlay;
        mp = MediaPlayer.create(context, resIdToPlay);
        if (mp != null) {
            mp.setLooping(true);
            mp.start();
        } else 
            Log.e("BackgroundMusicPlayer","Cant create MediaPlayer. MediaPlayer.create(context: "+context+", resIdToPlay: "+resIdToPlay+") returns null");


    }

    /** Stop the music */
    public static void stop() {

        if (mp != null) {
            isPaused = false;
            playingResId = 0;
            mp.stop();
            mp.release();
            mp = null;
        }
    }

    public static void pause() {

        if (mp != null){
            mp.pause();
            isPaused = true;
        }
    }

    public static void resume() {

        if (mp != null && isPaused){
            mp.start();
            isPaused = false;
        }
    }

}
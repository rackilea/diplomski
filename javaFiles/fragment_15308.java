public class Sound
{
    private static MediaPlayer currentlyPlayingSong,
    currentlyPlayingFX;

    public Sound() {}

    public void PlayFX(int fxId, Context context, boolean shouldLoop)
    {
        MediaPlayer fx = MediaPlayer.create(context, fxId);

        if (currentlyPlayingFX != fx)
        {
            StopFX();

            currentlyPlayingFX = fx;

            currentlyPlayingFX.start();

            currentlyPlayingFX.setLooping(shouldLoop);
        }
    }

    public void PlaySong(int songId, boolean shouldLoop, Context context)
    {
        MediaPlayer song = MediaPlayer.create(context, songId);

        if (currentlyPlayingSong != song)
        {
            StopSong();

            currentlyPlayingSong = song;

            currentlyPlayingSong.start();

            currentlyPlayingSong.setLooping(shouldLoop);
        }
    }

    public void StopFX()
    {
        if (currentlyPlayingFX != null)
        {
            currentlyPlayingFX.stop();

            currentlyPlayingFX.release();

            currentlyPlayingFX = null;
        }
    }

    public void StopSong()
    {
        if (currentlyPlayingSong != null)
        {
            currentlyPlayingSong.stop();

            currentlyPlayingSong.release();

            currentlyPlayingSong = null;
        }
    }
}
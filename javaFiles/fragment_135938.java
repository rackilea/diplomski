public class SoundPlayer implements Runnable
{
    private final sound sound;
    private final File soundFile;

    public SoundPlayer( sound sound, File soundFile )
    {
        this.sound = sound;
        this.soundFile = soundFile;
    }

    public void run()
    {
       sound.playAudio( soundFile );
    }
}
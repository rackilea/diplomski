public class MainActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener,AudioManager.OnAudioFocusChangeListener{
MediaPlayer mp;
AudioManager mAudioManager ;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
    int result = mAudioManager.requestAudioFocus(this, AudioManager.STREAM_MUSIC,
            AudioManager.AUDIOFOCUS_GAIN);
    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
        //got audio focus
        playAudio("bell.mp3",this);
    }

}

private void playAudio(String aud, Context context) {
    try {
        AssetFileDescriptor fileDescriptor =
                context.getAssets().openFd(aud);
        mp = new MediaPlayer();
        mp.setDataSource(fileDescriptor.getFileDescriptor(),
                fileDescriptor.getStartOffset(),
                fileDescriptor.getLength());
        fileDescriptor.close();
        mp.prepareAsync();
        mp.setOnPreparedListener(this);
    } catch (IllegalArgumentException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IllegalStateException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}


@Override
public void onPrepared(MediaPlayer mediaPlayer) {
    mp.start();
}

@Override
public void onAudioFocusChange(int i) {

}
}
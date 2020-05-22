public class MyActivity extends Activity implements OnAudioFocusChangeListener {

private AudioManager mAudioManager;

@Override
public void onCreate(Bundle savedInstanceState) {
    ...
    mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
    mAudioManager.requestAudioFocus(this, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
    ...
}

@Override
 public void onDestroy(){
     super.onDestroy();
     ...
     mAudioManager.abandonAudioFocus(this);
     ...
 }


@Override
public void onAudioFocusChange(int focusChange) {
    if(focusChange<=0) {
        //LOSS -> PAUSE
    } else {
        //GAIN -> PLAY
    }
}
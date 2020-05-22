public class Soundboard extends Activity {
    private SoundPool mSoundPool;
    boolean loaded = false;
    private int[] soundIDs;
    private int[] resIDs;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        mSoundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        mSoundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                            int status) {
                    loaded = true;
            }
        });
        resIDs = new int[]{R.raw.sound0,R.raw.sound1,R.raw.sound2.R.raw.sound3 };

        for(int i=0; i<resIDs.length; i++){
            soundIDs[i] = mSoundPool.load(this, resIDs[i], 1);              
        }
    };

    public boolean onTouchEvent(MotionEvent evt){

        Random r = new Random();
        int x = r.nextInt(resIDs.length);

        switch (evt.getAction()) 
        {
            case MotionEvent.ACTION_DOWN:
                AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                float actualVolume = (float) audioManager
                                .getStreamVolume(AudioManager.STREAM_MUSIC);
                float maxVolume = (float) audioManager
                                .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                float volume = actualVolume / maxVolume;
                // Is the sound loaded already?
                if (loaded) {
                        mSoundPool.play(soundIDs[x], volume, volume, 1, 0, 1f);
                        Log.i("Test", "Played sound");
                }
            startAnimating();
            return super.onTouchEvent(evt);

            case MotionEvent.ACTION_UP:
            break;
            default:
            break;
        }
        return true;
    }

    private void startAnimating() {

        ImageView wiub_screen01 = (ImageView) findViewById(R.id.wiub_screen01);
        Animation fadein01 = AnimationUtils.loadAnimation(this, R.anim.fade_in01);
        wiub_screen01.startAnimation(fadein01);

        ImageView wiub_screen00 = (ImageView) findViewById(R.id.wiub_screen00);
        Animation fadein00 = AnimationUtils.loadAnimation(this, R.anim.fade_in00);
        wiub_screen00.startAnimation(fadein00);
    }
}
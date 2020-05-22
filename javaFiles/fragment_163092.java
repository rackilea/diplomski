private SensorManager mSensorManager;
private ShakeEventListener mSensorListener;
SoundPool sp;
List<Integer> mSounds = new ArrayList<Integer>();
private Random mRandom = new Random();

protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.test);
    //Shake sound
    sp =  new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
    mSounds.add(sp.load(this, R.raw.one, 1));
    mSounds.add(sp.load(this, R.raw.two, 1));
    mSounds.add(sp.load(this, R.raw.three, 1);     

    //Shake
    mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    mSensorListener = new ShakeEventListener();   
    mSensorListener.setOnShakeListener(new ShakeEventListener.OnShakeListener() {

        public void onShake() {
            if (acceptCheck == 1)
            {
                sp.play(mSounds.get(mRandom.nextInt(mSounds.size())), 1, 1, 0, 0, 1);
            }
        }
      });
}
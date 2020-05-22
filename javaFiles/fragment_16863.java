private  SoundPool mSoundPool; 
    private int soundID;
    boolean loaded = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spxml);
        initializeSoundPool();
            playFile();
    }
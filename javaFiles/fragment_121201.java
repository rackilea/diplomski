MediaPlayer buttonSound; // already declared  but not initialized
ImageView display;
int toPhone;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.wallpaper);
    final MediaPlayer buttonSound = MediaPlayer.create(TutorialThree.this, R.raw.button_sound);
     // again declared and initialized. local to onCreate.
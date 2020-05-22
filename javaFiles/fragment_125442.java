@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //Button that is pressed to play the sound.
    imgBtn = findViewById(R.id.imageViewItm);

    //Listener that will run the onClick() method when imgBtn is pressed.
    imgBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Plays sound
            MediaPlayer sound = MediaPlayer.create(MainActivity.this, R.raw.sound_stuff);
            sound.start();
        }
    });
}
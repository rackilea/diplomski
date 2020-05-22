public ClassName extends AppCompactActivity {

    private String volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);

     int volume_level= am.getStreamVolume(AudioManager.STREAM_MUSIC);
      if (volume_level == 0) {
         volume = "Text...";
         Toast.makeText(context, volume, Toast.LENGTH_SHORT).show();
      }
   }
}
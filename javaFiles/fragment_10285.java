@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    button = (Button) findViewById(R.id.button);
    text = (TextView) findViewById(R.id.answer);

    AssetFileDescriptor afd;
    try {
        afd = getAssets().openFd("myaudio.mp3");
        mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
        mp.prepare();
    } catch (IOException e1) {
        e1.printStackTrace();
    }


     button.setOnClickListener(new OnClickListener() {

     @Override
     public void onClick(View v) {
        try {     
            mp.start();

        } catch (IllegalStateException e) {
            e.printStackTrace();
            }
        }
    });


}
VideoView videoView;

MediaController controller;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    videoView=findViewById(R.id.videoView);

    controller=new MediaController(this);

    videoView.setMediaController(controller);


    videoView.setVideoPath("http://strecker.co.za/ad_system/videos/video1.mp4");

    videoView.start();  

    videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

       @Override
       public void onCompletion(MediaPlayer mp) {
                    videoView.start();
       }
    });

    }
 }
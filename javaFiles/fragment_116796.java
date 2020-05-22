@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    final ImageView view = (ImageView) findViewById(R.id.shell);
    view.setVisibility(ImageView.VISIBLE);
    view.setBackgroundResource(R.drawable.animation_frame);

    view.post(new Runnable(){

      public void run(){
        AnimationDrawable frameAnimation =  (AnimationDrawable) view.getBackground();
        frameAnimation.start();
      }
    });
   }
}
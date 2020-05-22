public class FrameAnimationActivity extends Activity {

    AnimationDrawable frameAnimation;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ImageView img = (ImageView) findViewById(R.id.imageView1);

        img.setBackgroundResource(R.anim.frames);
        frameAnimation = (AnimationDrawable) img.getBackground();

        Button btn = (Button) findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                frameAnimation.start();
            }
        });

    }

}
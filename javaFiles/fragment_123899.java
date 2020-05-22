public class MainActivity extends Activity implements View.OnClickListener{

    ImageView imageView1, imageView2, imageView3;
    int x, y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x = 0;
        y = 0;

        imageView1 = (ImageView) findViewById(R.id.image1);
        imageView2 = (ImageView) findViewById(R.id.image2);
        imageView3 = (ImageView) findViewById(R.id.image3);

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
    }
@Override
public void onClick(View v) {
   TranslateAnimation animation = new TranslateAnimation(0, 0, 0, 50);
                animation.setDuration(1000);
                animation.setFillAfter(false);
                animation.setAnimationListener(new MyAnimationListener(v));

                v.startAnimation(animation);
                x += 0;
                y += 50;
}
    private class MyAnimationListener implements Animation.AnimationListener {
        private View mView;

        public MyAnimationListener(View v)
       {
           this.mView = v;
       }
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            mView.clearAnimation();
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(mView.getWidth(),
                mView.getHeight());
            lp.setMargins(x, y, 0, 0);
            mView.setLayoutParams(lp);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
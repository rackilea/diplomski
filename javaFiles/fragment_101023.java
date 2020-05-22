public class MyActivity extends AppCompatActivity {

    private RelativeLayout.LayoutParams params;

    public void setClickAnimation(final Activity activity) {
        // if you want to change the size of the animation, change the size on the dimens.xml
        int size = (int) activity.getResources().getDimension(R.dimen.click_animation);
        params = new RelativeLayout.LayoutParams(size, size);

        // you want the parent layout of the activity
        final RelativeLayout view = (RelativeLayout) activity.findViewById(R.id.main_layout);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // you maybe won't need this compensation value
                    int compensation = (int) activity.getResources().getDimension(R.dimen.click_compensation);
                    try { startAnimation(view, (int) event.getX() - compensation, (int) event.getY() - compensation); }
                    catch (IOException e) { e.printStackTrace(); }
                }
                return true;
            }
        });
    }

    private void startAnimation(RelativeLayout view, int x, int y) throws IOException {
        params.leftMargin = x;
        params.topMargin = y;

        // those are from the lib you imported
        final GifImageView anim = new GifImageView(this);
        // if you don't have it yet, put the gif you want on the assets folder
        final GifDrawable gifFromResource = new GifDrawable(getAssets(), "click_animation.gif");
        gifFromResource.addAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationCompleted(int loopNumber) {
                anim.setVisibility(View.GONE);
                gifFromResource.stop();
                gifFromResource.recycle();
            }
        });

        anim.setBackground(gifFromResource);
        gifFromResource.start();

        view.addView(anim, params);
    }
}
public class Foo extends View implements AnimationListener, OnCompletionListener {
    private MyAnimation mAnim;
    private MyMediaPlayer mMediaPlayer;
    private boolean mIsOneActivityFinished = false;

    synchronized private void onActivityFinished() {
        if(!mIsOneActivityFinished) {
             // The first activity is finished. Set the flag and return.
             mIsOneActivityFinished = true;
             return;
        }

        // Do stuff when both activities are finished...
    }

    public void start() {
        mAnim = new MyAnimation();
        mAnim.setAnimationListener(this);
        startAnimation(mAnim);

        mMediaPlayer = MyMediaPlayer();
        mMediaPlayer.setOnCompletionListener(this);
        mMediaPlayer.start();
    }


    // Called when mAnim finishes
    @Override
    public void onAnimationEnd(Animation animation) {
        onActivityFinished();
    }


    // Called when mMediaPlayer finishes
    @Override
    public void onCompletion(MediaPlayer mp) {
        onActivityFinished();
    }
}
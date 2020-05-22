public class theview extends SurfaceView implements SurfaceHolder.Callback {
    private final SurfaceHolder mSurfaceHolder;
    public theview(Context context, AttributeSet attrs) {
        super(context, attrs);
        mSurfaceHolder = getHolder();
        //(other game-initialization code omitted)
        thread = new LunarThread();

    public void surfaceCreated(SurfaceHolder holder) {
        //(other game-resuming code omitted)
        mRun=True;
        thread.start();
    }

    class LunarThread extends Thread {
        @Override
        public void run() {
            Canvas c=null;
            while (mRun) {
                try {
                    LunarThread.sleep(0, 1); // <---the LG G4 needs this line or the game doesn't load! Sleep duration didn't matter.
                }catch(InterruptedException ignored){}

                if(c==null){
                    LunarThread.yield();//app is still loading; wait for it.
                }
                try {
                    c = mSurfaceHolder.lockCanvas(null); // <---- this is the line where the LG G4 freezes without the above sleep()
                    if (c != null) {
                        synchronized (mSurfaceHolder) {
                            if (mMode == STATE_RUNNING) doPhysics();
                            doDraw(c);
                        }
                    }
                }
                finally {
                    // do this in a finally so that if an exception is thrown
                    // during the above, we don't leave the Surface in an
                    // inconsistent state
                    if (c != null) {
                        mSurfaceHolder.unlockCanvasAndPost(c);
                    }
                }

}
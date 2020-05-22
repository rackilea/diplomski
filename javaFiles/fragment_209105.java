public void playVideo(final String videoURL)
{
    Runnable runnable = new Runnable(){

        @Override
        public void run()
        {
             MyTask mt = new MyTask(mVideoView);
             Replay.executeVideo(videoURL, 
                  MirrorActivity.this, 
                  mVideoView, 
                  mt);
        }
    });

    Handler mainHandler = new Handler(Looper.getMainLooper());
    mainHandler.post(runnable);
}
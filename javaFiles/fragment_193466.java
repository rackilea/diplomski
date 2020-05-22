private void startVideo()
{
    introVideo.setBackgroundDrawable(null);
    introVideo.postDelayed(new Runnable() {
        public void run()
        {
            if (!introVideo.isPlaying())
                return;

            introVideo.setBackgroundResource(R.drawable.video_still_image);
            // other stuff here, for example a custom transition to
            // another activity
        }
    }, 7500); // the video is roughly 8000ms long
    introVideo.start();
}
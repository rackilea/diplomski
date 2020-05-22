if (fromUser) {

            Runnable mRunnable = new Runnable() {

                @Override
                public void run() {
                    int min, sec;

                    if (mediaPlayer != null /*Checking if the
                       music player is null or not otherwise it
                       may throw an exception*/) {
                        int mCurrentPosition = seekBar.getProgress();

                        min = mCurrentPosition / 60;
                        sec = mCurrentPosition % 60;

                        Log.e("Music Player Activity", "Minutes : "+min +" Seconds : " + sec);

                        /*currentime_mm.setText("" + min);
                        currentime_ss.setText("" + sec);*/
                    }
                    mHandler.postDelayed(this, 1000);
                }
            };
            mRunnable.run();}
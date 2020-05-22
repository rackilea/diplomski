progressbar.setVisibility(View.VISIBLE);

 videoView.setOnPreparedListener(new OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {



                mp.start();

                mp.setOnVideoSizeChangedListener(new OnVideoSizeChangedListener() {

                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int arg1, int arg2) {
                        // TODO Auto-generated method stub
                        Log.e(TAG, "Changed");
                        progressbar.setVisibility(View.GONE);
                        mp.start();
                    }
                });


            }
        });
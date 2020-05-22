mVideoView.setOnErrorListener(new OnErrorListener(){
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                // TODO Auto-generated method stub
                statusText.setText("ERROR PLAYING VIDEO");
                mVideoView.pause();
                return true;
            }
        });
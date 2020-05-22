final VideoView videoview = (VideoView) findViewById(R.id.button10);
    Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.group_project);
    videoview.setVideoURI(uri);
    videoview.setOnPreparedListener(new OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoview.start();    
            }
        });
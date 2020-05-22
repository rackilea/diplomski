private void showToast(String text){
       Toast.makeText(this,text, Toast.LENGTH_SHORT).show();// this = Context
       MediaPlayer mediaplayer = MediaPlayer.create(MainActivity.this, R.raw.abc);//You Can Put Your File Name Instead Of abc
           mediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.reset();
                mediaPlayer.release();
            }
        });
        mediaplayer.start();
    }
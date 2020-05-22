public MediaPlayer mp=null;

@Override
protected void onDestroy() {
    if (mp!=null)
        mp.stop();

    super.onStop();
}

@Override
protected void onResume() {

    super.onResume();

    if (mp==null){
        self=this;
        Thread thMusic= new Thread(new Runnable(){
            public void run(){
                mp= MediaPlayer.create(self,R.raw.dizzy );
                mp.start();
            }
        });

        thMusic.start();
    }
    else
        mp.start();
}

@Override
protected void onPause() {
    if (mp!=null)
        mp.pause();

    super.onPause();
}
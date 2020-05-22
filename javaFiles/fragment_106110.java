@Override
    protected void onPause()
    {
       super.onPause();
       if(s1.isPlaying()){
            s1.stop();
            s1.release();
            }
       if(s2.isPlaying()){
            s2.stop();
            s2.release();
            }
    }
onPageChanged(int position)
    {
     mp.release();
     mp=null;
    //Now initialiase it again with page two's music.
    mp = MediaPlayer.create(MainActivity.this, R.raw.aa);
    }
if (mMediaplayer!=null && mMediaplayer.isPlaying()) {
    mMediaplayer.stop();
    mMediaplayer.release();
} 
mMediaplayer = new MediaPlayer();
mMediaplayer.setDataSource(mp3);
mMediaplayer.prepare();//prepare to play
mMediaplayer.start();
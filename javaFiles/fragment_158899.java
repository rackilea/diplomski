if (mMediaplayer!=null && mMediaplayer.isPlaying()) {
    stopPlaying();
} 
mMediaplayer = new MediaPlayer();
mMediaplayer.setDataSource(mp3);
mMediaplayer.prepare();//prepare to play
playMedia();
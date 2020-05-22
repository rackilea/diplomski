// song is playing
mMediaplayer = new MediaPlayer(); // you created a new player
mMediaplayer.setDataSource(mp3);
mMediaplayer.prepare();//prepare to play
if (mMediaplayer.isPlaying()) { // new player is not in playing state
    stopPlaying();              // so you always checking the state of new player
} else {
    playMedia();
}
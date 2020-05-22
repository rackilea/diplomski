if (mplayer.isPlaying()) {
    mp.stop();
}
mplayer.reset();
mplayer.setDataSource(abs_filepath);//set the path
mplayer.prepare();
mplayer.start();
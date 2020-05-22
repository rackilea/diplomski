if (mediaPlayer != null) {
  if(mediaPlayer.isPlaying()){
     mediaPlayer.stop();
     mediaPlayer.reset()
     mediaPlayer.setDataSource(new music to play);
     mediaPlayer.prepare();
  }
}
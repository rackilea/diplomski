public void playMusic(Music music){

    if(game.menuMusicBool && !music.isPlaying()){
         music.play();
         music.setLooping(true);
     }
}
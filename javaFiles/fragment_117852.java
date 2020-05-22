public void player(Context context){

if(player == null){
        player = MediaPlayer.create(context, R.raw.onepieceost);
    }
   if(player != null || !player.isPlaying()){
        player.start();
    }else {
        player = new MediaPlayer();
        try {
            player.prepare();
            player.start();

        } catch (IOException e) {
            //null
        }
    }
}
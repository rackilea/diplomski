for (int j = 0; j < players.size(); j++){
    player.setOnEndOfMedia(new Runnable(){
        @Override public void run(){
        i++;
        list.getSelectionModel().select(i);
        player = players.get(i);
        player.play();
        slide(i);
        csong.setText(playlist.get(i).getName());
        }
    });
}
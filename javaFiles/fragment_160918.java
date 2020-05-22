player.setOnEndOfMedia(new Runnable(){
    @Override
    public void run() {
        i++ ;
        play();
    }
});
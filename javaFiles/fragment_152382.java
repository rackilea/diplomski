Runnable run = new Runnable(){

    @Override
    public void run() {
        seekBarUpdate();
    }

};

public void seekBarUpdate(){
    sBar.setMax(player.getDuration());
    sBar.setProgress(player.getCurrentPosition());
    seekHandler.postDelayed(run, 25);
}
final Handler handler = new Handler();
handler.post(new Runnable(){

    @Override
    public void run(){
        // change your text here
        handler.postDelayed(this, 3*1000L);
    }
});
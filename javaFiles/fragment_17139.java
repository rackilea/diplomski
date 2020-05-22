Handler mHandler = new Handler();
mHandler.postDelayed(new Runnable(){
    public void run(){
        PictureA.setVisibility(View.Visible);
        PictureB.setVisibilty(View.Visible);
    }
}, 5000);
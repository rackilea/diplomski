loadImage("imageLink");

final Handler handler = new Handler();
handler.postDelayed(new Runnable() {
    @Override
    public void run() {
        //Do something after 3sec
        loadImage("next ImageLink");
    }
}, 3000);
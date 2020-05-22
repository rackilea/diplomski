final Handler handler = new Handler();
handler.postDelayed(new Runnable(){
    public void run() {
        for (int i = 60; i >= 1; i--) {
            box2.setText("\r" + i + " sec left");
        }
        handler.postDelayed(this, 1000);
    }
}, 0);
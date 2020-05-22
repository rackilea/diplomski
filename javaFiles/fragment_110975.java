new Handler(Looper.getMainLooper()).post(new Runnable(){
    @Override
    public void run() {
        score.setText(scorenewe.toString());
    }
});
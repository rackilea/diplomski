handler.postDelayed(r, 5000);

final Runnable r = new Runnable() {
    public void run() {
        changeToOrigColor();
    }
};
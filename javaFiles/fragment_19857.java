Handler handler = new android.os.Handler();
handler.postDelayed(new Runnable() {
    public void run() {
        getit(savedInstanceState);
    }
}, Long.parseLong(setcas));
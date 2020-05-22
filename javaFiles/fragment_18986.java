Handler handler = new Handler();
Runnable runnable = new Runnable() {
    @Override
    public void run() {
        Intent i = new
                Intent(MapsActivity.this,MapsActivity.class);
        startActivity(i);
        finish();
    }
};
handler.post(runnable);

// use this when you don't want callback to be called anymore
handler.removeCallbacks(runnable);
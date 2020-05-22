long delay = 5000; //5 seconds
final TextView loadingTextView = findViewById(R.id.loading);
final Handler handler = new Handler();
Runnable runnable = new Runnable() {
    @Override
    public void run() {
        loadingTextView.setText(FetchRandomLoadingText());
        handler.postDelayed(this, delay);
    }
};
handler.post(runnable);
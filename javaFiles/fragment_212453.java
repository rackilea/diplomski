public void click(final View view) throws InterruptedException {

    final Button btn = findViewById(view.getId());

    btn.setBackgroundColor(Color.parseColor("#0000ff"));
    btn.setClickable(false);

    Handler handler = new Handler(); 
    handler.postDelayed(new Runnable() {
        @Override 
        public void run() { 
            btn.setBackgroundColor(Color.parseColor("#e2e2e2"));
            btn.setClickable(true);
        } 
    }, 1000); 
}
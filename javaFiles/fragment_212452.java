public void click(final View view) throws InterruptedException {

    final Button btn = findViewById(view.getId());

    btn.setBackgroundColor(Color.parseColor("#0000ff"));
    btn.setClickable(false);

    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                btn.setBackgroundColor(Color.parseColor("#e2e2e2"));
                btn.setClickable(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    t.start();
}
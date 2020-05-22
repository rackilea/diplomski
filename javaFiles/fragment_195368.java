private void ProcessNumbers()
{
    TextView textViewProcessNumbers = (TextView) findViewById(R.id.textViewProcessNumbers);
    textViewProcessNumbers.setText("Processing...");
    final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            //Do something after 30000ms
            textViewProcessNumbers.setText("Processed...");
        }
    }, 30000);
}
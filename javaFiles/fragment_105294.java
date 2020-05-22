Handler handler = new Handler();
....

@Override
public void onClick(View v) {
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
        // set your button color here, no need to use runOnUiThread()
        // as this run() method is executed on Main thread
        }
    }, 100);
}
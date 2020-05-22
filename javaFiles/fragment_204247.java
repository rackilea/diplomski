class MainActivity extends Activity {

    // The handler is associated with your Activity's thread
    private Handler _handler = new Handler();
    // ...

    private Thread _worker = new Thread() {

        @Override
        public void run() {
          _handler.post(new Runnable() {
             @Override
             public void run() {
                Toast.makeText(MainActivity.this, "Some text", Toast.LENGTH_SHORT).show();
             }
          });
        }
    };
};
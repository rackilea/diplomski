Handler h = new Handler();
final Runnable r = new Runnable() {
        int count = 0;
        @Override
        public void run() {
            count++;
            textView.setText(""+count*1.8);
            h.postDelayed(this, 1000); //ms
        }
    };
h.postDelayed(r, 1000); // one second in ms
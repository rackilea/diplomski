final Handler handler = new Handler();
    final int delay = 1000; //milliseconds
    handler.postDelayed(new Runnable(){
        public void run(){
            Log.e("LOG","HIT");
            handler.postDelayed(this, delay);
        }
    }, delay);
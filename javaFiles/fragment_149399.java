final Handler handler = new Handler(); 
    Timer timer2 = new Timer(); 
    TimerTask testing = new TimerTask() {
        public void run() { 
            handler.post(new Runnable() {
                public void run() {
                    Toast.makeText(mainActivity.this, "test", Toast.LENGTH_SHORT).show();
                }

            });


        }
    };
    timer2.schedule(testing, 1000);
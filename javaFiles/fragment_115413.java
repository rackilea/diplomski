new Thread(new Runnable(){
            public void run(){
            mHandler = new Handler();
            context = this;
            ...
        }
    }).start();
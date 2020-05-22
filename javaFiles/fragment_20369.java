handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getLocation();
            }
        }, 1000);
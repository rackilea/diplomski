new Timer().schedule(new TimerTask() {
    @Override
    public void run() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //this will run on UI thread so you can update views here
            }
        });
    }
}, 2000, 2000);
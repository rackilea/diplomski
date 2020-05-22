Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() { // you should only update UI in the main/ui thread
                    @Override
                    public void run() {
                        // do your updating here
                    }
                });
            }
        }, 16, 16); // 60 fps
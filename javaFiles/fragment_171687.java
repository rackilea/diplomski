int myTimeCounter = 60;
    Timer myTimer = new Timer();
    private void startRepeatedTask() {
        myTimer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                runOnUiThread(new Runnable() {
                    public void run() {
                        if (myTimeCounter == 0) {
                            myTimer.cancel();
                            callActivity();
                            return;
                        }
                        //Log.d(TAG, "timer=" + String.valueOf(myTimeCounter));
                        myTimeCounter--;
                    }
                });
            }
        }, 0, 1000);
    }
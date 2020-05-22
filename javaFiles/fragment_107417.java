// call the method cancel to stop it
    java.util.Timer time = new java.util.Timer();

    time.scheduleAtFixedRate(new java.util.TimerTask() {
            @Override
            public void run() {
                //Blah Blah Blah       
            }
        }, 20, 5000);

    time.cancel();
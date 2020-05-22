try {
        funcAThread.start();
        funcBThread.start();
        funcAThread.join();
        funcBThread.join();
        new Thread(new Runnable() {
            @Override
            public void run() {
                startFunctionC();
                //once completed, call UI thread for D !
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        startFunctionD();
                    }
                });
            }
        }).start();
    } catch (InterruptedException e) {
        Log.getStackTraceString(e);
    }
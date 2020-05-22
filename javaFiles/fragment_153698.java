public void process() {
        Thread funcAThread = new Thread(new Runnable() {
            @Override
            public void run() {
                startFunctionA();
            }
        });

        Thread funcBThread = new Thread(new Runnable() {
            @Override
            public void run() {
                startFunctionB();
            }
        });

        try {
            funcAThread.start();
            funcBThread.start();
            funcAThread.join();
            funcBThread.join();
            startFunctionC();
            startFunctionD();
        } catch (InterruptedException e) {
            Log.getStackTraceString(e);
        }
    }
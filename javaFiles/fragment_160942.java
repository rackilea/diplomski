Handler innerHandler;

(new Thread(new Runnable() {

            @Override
            public void run() {
                Looper.prepare();

                innerHandler = new Handler() {
                    @Override
                    public void handleMessage(Message message) {
                        Toast.make(...);
                    }

                    @Override
                    public void dispatchMessage(Message message) {
                        handleMessage(message);
                    }
                };

                Message message = innerHandler.obtainMessage();
                innerHandler.dispatchMessage(message);
                Looper.loop();
            }
        })).start();
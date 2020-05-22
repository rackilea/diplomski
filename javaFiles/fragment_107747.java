new Thread(new Runnable() {
            @Override
            public void run() {
                tcpConection.write("Hello torno!");
            }
        }).start();
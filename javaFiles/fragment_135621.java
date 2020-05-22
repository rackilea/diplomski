new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    String s = checkIp();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
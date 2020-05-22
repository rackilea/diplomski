void m(final int param) {
        new Thread(new Runnable() {
            public void run() {
                System.err.println(param);
            }
        }).start();
    }
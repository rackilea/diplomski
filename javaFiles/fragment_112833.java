public void startMethod() {
    new Thread() {
        public void run() {
            for (int i = 0; i < 5000; i++) {
                doSmething();
                if (i == 0) {
                    sendMsg("Start");
                }

            }
            sendMsg("End");
        }
    }.start();
}
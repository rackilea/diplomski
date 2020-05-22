new Thread() {
        public void run() {
            chatserver server = new chatserver();
            server.go();
        }
    }.start();
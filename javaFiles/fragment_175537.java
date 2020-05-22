Runtime.getRuntime().addShutdownHook(new Thread() {
        @Override
        public void run() {
            //your cleanup codes
        }
    });
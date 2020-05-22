Runtime.getRuntime().addShutdownHook(
    new Thread(new Runnable() {
        @Override
        public void run() {
            // this is executed on shut-down. put whatever.
        }
    }));
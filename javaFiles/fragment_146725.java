public static void get(URI[] uris) {
    ExecutorService executor = Executors.newFixedThreadPool(4);
    for (final URI uri : uris) {
        executor.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                InputStream input = uri.toURL().openStream();
                try {
                    Result result = readIntput(input);
                    SwingUtilities.invokeAndWait(new Runnable() {
                        @Override
                        public void run() {
                            // notify UI
                        }
                    });
                } finally {
                    input.close();
                }
                return null;
            }
        });
    }
}
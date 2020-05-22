ExecutorService executor = Executors.newFixedThreadPool(1);
Callable<String> readTask = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return readBuffer();
            }
        };
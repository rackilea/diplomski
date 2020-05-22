upgrade.setOnAction((event) -> {
    appendToOutputText("Reading in hex file");
    Task<Void> task1 = new Task<Void>() {
        @Override
        protected Void call() throws Exception {
            python.executeCommand("readhexfile " + hexFile.getAbsolutePath());
            return null;
        }
    };
    task1.setOnSucceeded((event) -> {
        appendToOutputText("Starting upgrade, this will take about 4 minutes to complete");
    });

    Task<Void> task2 = new Task<Void>() {
        @Override
        protected Void call() throws Exception {
            python.executeCommand("upgrade 158 158444");
            return null;
        }
    };
    task2.setOnSucceeded((event) -> {
        System.out.println("task2 done!");
    });


    ExecutorService es = Executors.newSingleThreadExecutor();
    es.submit(task1);
    es.submit(task2);
    es.shutdown();
)};
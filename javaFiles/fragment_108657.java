upgrade.setOnAction((event) -> {
    appendToOutputText("Reading in hex file");
    Task<Void> task1 = new Task<Void>() {
        @Override
        protected Void call() throws Exception {
            python.executeCommand("readhexfile " + hexFile.getAbsolutePath());
            Platform.runLater(()->{appendToOutputText("Starting upgrade, this will take about 4 minutes to complete");});
            python.executeCommand("upgrade 158 158444");

            return null;
        }
    };
    task1.setOnSucceeded((event) -> {
        System.out.println("task1 done!");
    });

    ExecutorService es = Executors.newSingleThreadExecutor();
    es.submit(task1);
    es.shutdown();
)};
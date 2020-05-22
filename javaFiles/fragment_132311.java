Button btn = new Button("Run Task");
btn.setOnAction(actionEvent -> {
    Task<String> task = new Task<String>() {
        @Override
        protected String call() throws Exception {
            //simulating long-running task
                Thread.sleep(3_000);
            //return result
                return "Warren Nocos";
        }
    };
    task.setOnSucceeded(event -> {
        String result = task.getValue();
        System.out.println(result);
    });
    task.setOnFailed(event -> {
        task.getException().printStackTrace();
    });
    threadPool.execute(task);
});
boxRep.setOnMousePressed(event -> {
    Task<String> httpTask = new Task<String>() {
        @Override
        public String call() throws Exception {
            return MySendHttp(ip, port, request);
        }
    };

    Thread thread = new Thread(httpTask);

    httpTask.setOnSucceeded(e -> {
        boxRep.setDisable(false);
        String responseCode = httpTask.getValue();
        // process...
    });


    boxRep.setDisable(true);

    thread.start();
});
Service process = new Service() {
    @Override
    protected Task createTask() {
        return new Task() {
            @Override
            protected ObjectX call() throws Exception {

                updateMessage("Some message that may change with execution");
                updateProgress( workDone, totalWork ); 
                return ObjectX;
            }
        };
    }
};

process.setOnSucceeded( e -> {

    ObjectX processValue = (ObjectX)process.getValue();

    // TODO, . . . 
    // You can modify any GUI element from here...
    // ...with the values you got from the service
});

process.start();
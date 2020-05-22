ScheduledService<String> service = new ScheduledService<>() {

    @Override
    protected Task<String> createTask() {
        return new Task<>() {

            @Override
            protected String call() throws Exception {
                return streaming.processData();
            }

        };
    }

};

updateLabel.textProperty().bind(service.lastValueProperty());
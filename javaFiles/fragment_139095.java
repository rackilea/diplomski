public void runTask(Stage stage, final int input /* can be any type */) throws URISyntaxException, IOException {

    Service<Boolean> service = new Service<Boolean>() {

        @Override
        protected Task<Boolean> createTask() {
            return new Task<Boolean>() {
                @Override
                protected Boolean call() throws InterruptedException, URISyntaxException, IOException {
                    // some time consuming task here
                    // use the input arguments and perform some action on it
                    // then set the process result to a Boolean and return after the task is completed
                    // also keep hold back any other process to from executing on UI 

                    Boolean returnValue = ... ;
                    return returnValue;
                }
            };
        }

    };

    Dialogs.create()
            .owner(stage)
            .title("Performing Task!")
            .masthead("Please wait...")
            .showWorkerProgress(service);

    service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {

        @Override
        public void handle(WorkerStateEvent event) {
            System.out.println("done:" + event.getSource().getValue());
        }
    });

    service.setOnFailed(new EventHandler<WorkerStateEvent>() {

        @Override
        public void handle(WorkerStateEvent event) {
            throw new UnsupportedOperationException("Failed."); //To change body of generated methods, choose Tools | Templates.
        }
    });

    service.setOnCancelled(new EventHandler<WorkerStateEvent>() {

        @Override
        public void handle(WorkerStateEvent event) {
            throw new CancellationException("Cancelled."); //To change body of generated methods, choose Tools | Templates.
        }
    });

    service.start();

}
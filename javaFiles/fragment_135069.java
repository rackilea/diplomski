task = new Service(){
    @Override
    protected Task createTask() {
        System.out.println("Task created");
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                while(!isCancelled()) {
                    // Do stuff here

                }
                return null;
            }
        };
    }
};

Button cancelButton = new Button("Cancel");
cancelButton.setOnAction(e -> task.cancel());
Task<MyReturnType> task = new Task<MyReturnType>() {

    @Override
    protected MyReturnType call() throws Exception {
        return someLongCalculation(); // may throw an exception
    }

};

task.setOnSucceeded(evt -> {
    // we're on the JavaFX application thread here
    MyReturnType result = task.getValue();
    label.setText(result.toString());

});

task.setOnFailed(evt -> {
    // we're on the JavaFX application thread here
    label.setText("Error: " + task.getException().getMessage());
});
new Thread(task).start(); // alternatively use ExecutorService
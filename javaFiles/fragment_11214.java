public void finish() {

    Task task = new Task<Void>() {

        @Override
        public Void call() throws Exception {
            StandingsCreationHelper.createStandingsFile();
            return null;
        }
    };

    task.setOnFailed(e -> {
        Throwable ex = task.getException();
        Alert alertStandingsFileExecution = Dialog.getExceptionDialog(ex);
        alertStandingsFileExecution.showAndWait();
    });

    task.setOnSucceeded(e -> owner.close());

    Scene scene = new Scene(new ProgressBarWindow(owner));
    owner.setScene(scene);
    owner.show();

    new Thread(task).start();

}
@Override
public void start(Stage primaryStage) {
    TextArea textArea = new TextArea();
    Button button = new Button("Get Text");
    button.setOnAction(evt -> {
        button.setDisable(true);
        Task<String> task = new Task<String>() {

            @Override
            protected String call() throws Exception {
                // do long-running operations not modifying the UI
                // here
                StringBuilder sb = new StringBuilder();

                final int count = 10;

                for (int i = 0; i < count; i++) {
                    // update message & progress
                    // the messageProperty / progressProperty will be modified on
                    // the javafx application thread
                    updateProgress(i, count);
                    updateMessage("Loading part " + (i+1));

                    // simulate long-running operation
                    Thread.sleep(500);
                    sb.append('\n').append(i);
                }
                updateProgress(count, count);
                return sb.toString();
            }

        };

        // while loading, display the task message in the TextArea
        textArea.textProperty().bind(task.messageProperty());

        task.setOnSucceeded(succeededEvent -> {
            // only modifications of the UI here, no longrunning tasks
            textArea.textProperty().unbind();

            // use result of the task
            textArea.setText(task.getValue());

            button.setDisable(false);
        });

        // run task on different thread
        new Thread(task).start();
    });

    Scene scene = new Scene(new VBox(textArea, button));

    primaryStage.setScene(scene);
    primaryStage.show();
}
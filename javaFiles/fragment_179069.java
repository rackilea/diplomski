private ExecutorService executor;

@Override
public void init() throws Exception {
    executor = Executors.newSingleThreadExecutor();
}

@Override
public void stop() throws Exception {
    executor.shutdownNow();
    // TODO: handle unsent messages or replace with executor.shutdown()
}

private void postMessage(String message) {
    executor.submit(() -> {
        System.out.println("sending message: "+message);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
        }
    });
}

@Override
public void start(Stage primaryStage) {
    TextField textField = new TextField();

    textField.setOnAction(evt -> {
        postMessage(textField.getText());
        textField.clear();
    });

    Scene scene = new Scene(textField);

    primaryStage.setScene(scene);
    primaryStage.show();
}
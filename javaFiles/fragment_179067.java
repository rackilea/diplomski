@Override
public void start(Stage primaryStage) {
    TextField textField = new TextField();
    List<String> messages = new LinkedList<>();
    Thread thread = new Thread(() -> {
        while (true) {
            String message;
            synchronized (messages) {
                if (messages.isEmpty()) {
                    // empty message queue -> wait
                    try {
                        messages.wait();
                    } catch (InterruptedException ex) {
                        // unknown cause of interrupt -> just try reading the messages anew
                        continue;
                    }
                }
                message = messages.remove(0);
            }
            System.out.println("sending message: " + message);

            try {
                // simulate delay
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
            }
        }
    });
    thread.setDaemon(true);
    thread.start();

    textField.setOnAction(evt -> {
        synchronized (messages) {
            // add new message to queue
            messages.add(textField.getText());

            // notify thread
            messages.notify();
        }
        textField.clear();
    });

    Scene scene = new Scene(textField);

    primaryStage.setScene(scene);
    primaryStage.show();
}
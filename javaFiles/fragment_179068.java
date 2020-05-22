LinkedBlockingQueue<String> messages = new LinkedBlockingQueue<>();
Thread thread = new Thread(() -> {
    while (true) {
        String message;
        try {
            message = messages.take();
        } catch (InterruptedException ex) {
            continue;
        }
        System.out.println("sending message: "+message);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
        }
    }
});
thread.setDaemon(true);
thread.start();

textField.setOnAction(evt -> {
    try {
        messages.put(textField.getText());
        textField.clear();
    } catch (InterruptedException ex) {
    }

});
public void sendAsync(Command command, Consumer<Boolean> callback) {
    new Thread(() -> {
        boolean successful = send(command);
        if(callback != null)
            callback.accept(successful);
    }).start();
}
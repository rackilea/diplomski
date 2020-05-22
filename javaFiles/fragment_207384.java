AbstractHandler handler = handlerMap.get(command + ": ");
if (handler != null) {
    /* ... */
    handler.handleData(socket, lines);
    System.err.println("Handler is done!");
} else {
    /* ... */
}
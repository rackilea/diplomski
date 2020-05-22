for (;;) {
    Request r = requestQueue.take();

    if (r == shutdown) {
        break;
    }

    // connect to server, send r.send bytes to it
    // read back the response as a byte array:

    byte[] response = ...

    SwingUtilities.invokeAndWait(new Runnable() {
        public void run() {
            currentHandler.handleReply(
                new ObjectInputStream(
                    new ByteArrayInputStream(response)
                ).readObject()
            );
        }
    });
}
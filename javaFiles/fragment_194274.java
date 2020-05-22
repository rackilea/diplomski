public void processMessagesFromClient(Client client) {
    Document Message;

    while (true) {
        processMessage(client);
    }
}

private static synchronized processMessage(Client client) {
    try {
        message = client.inputStream.readObject();

        String messageType = getMessageType(message);

        // Route the message depending on its type
        switch (messageType) {
            case LOGIN:
                userModel.handleLogin();
            ...
            etc...
        }
    } catch(Exception e) {}
}
// Listen for messages
xmppClient.addInboundMessageListener(new Consumer<MessageEvent>() {

    public void accept(MessageEvent e) { 
        Message message = e.getMessage();
        // Handle inbound message.
    }
});
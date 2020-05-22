private Consumer<MessageEvent> inboundMessageListener;

//should be called during startup only
public void initialize() {
    inboundMessageListener = new Consumer<MessageEvent>() {

        public void accept(MessageEvent e) { 
            Message message = e.getMessage();
            // Handle inbound message.
        }
    };
}

//can be reused for more than one XMPP client, assuming there's no difference in handling different clients
public void addInboundMessageListener() {

    xmppClient.addInboundMessageListener(inboundMessageListener);
}
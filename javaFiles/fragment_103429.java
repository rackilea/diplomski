JID jid = new JID("youraccount@jabber.org");
Message msg = new MessageBuilder()
    .withRecipientJids(jid)
    .withBody("Hello i'm a fancy GAE app, how are you?")
    .build();                    
XMPPService xmpp = XMPPServiceFactory.getXMPPService();
if (xmpp.getPresence(jid).isAvailable()) {
   SendResponse status = xmpp.sendMessage(msg);               
}
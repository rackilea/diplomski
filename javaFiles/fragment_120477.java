public void processMessage(Chat chat, Message message) {
    if (message.getType() == Message.Type.chat) {
        for(XMPPmessageListener l: listeners){
            l.readMsg(chat.getParticipant().toString(), message.getBody().toString());
        }
    }
}
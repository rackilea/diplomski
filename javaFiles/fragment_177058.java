class MessageFactory {
    private StorableMessage storableMessage;
    private PrivateMessage privateMessage;
    private PublicMessage publicMessage;
    //You can either create the above using new operator or inject it using some Dependency injection framework.

    public getMessage(MessageModel message) {
        switch(message.typeId) {
            case 1: return storableMessage; 
            case 2: return publicMessage;
            case 3: return privateMessage
            default: //Handle appropriately
        }
    }
}
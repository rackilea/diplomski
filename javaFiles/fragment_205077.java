public abstract class MessageType<T extends Message> implements MessageFactory<T>{

    public static final MessageType<ObjectMessage> PLAYER_REGISTER = new MessageType<ObjectMessage>() {

        @Override
        public ObjectMessage create(Session session) { //Error, remove @Override annotation
            return null;
        }
    };

    private MessageType(){ }
}
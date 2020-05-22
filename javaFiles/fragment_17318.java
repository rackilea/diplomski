public class MessageRepositoryFactory implements Factory<MessageRepository> {
    @Override
    public MessageRepository provider() {
        return new DefaultMessageRepository();
    }
    ...
}
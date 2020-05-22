@Component
public class MessageServiceImpl implements MessageService {
    private Collection<String> messageLibrary = new LinkedList<>();

    @Override
    public void createMessage(String message) {
        messageLibrary.add(message);
    }

    @Override
    public Collection<String> fetchAllMessages() {
        return messageLibrary;
    }
}
@Component
public interface MessageService {

    void createMessage(String message);

    Collection<String> fetchAllMessages();
}
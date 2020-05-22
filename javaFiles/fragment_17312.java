@Service
public class DefaultMessageRepository implements MessageRepository {

    @Inject
    private Session session; <-------------------+
                                                 | // You shadow session
    public void saveMessage(Message message) {   |
        Session session = null;   <--------------+
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
        ...
    }
    ...
}
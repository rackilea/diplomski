@Service
public class MyRequiredService {

    @PostConstruct
    public void init() {
        connect();
    }

    public void connect() {
        // ...
    }
}
@Service
public class MyService {
    @PreDestroy
    public void cleanUp() {
        //free resources...
    }
}
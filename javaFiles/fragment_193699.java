@Component
@Profile("default")
public class SocketServerImpl implements SocketServer {
    /**
    * Instantiates a new socket server.
    */
    public SocketServerImpl() {
        /* Standard stuff */
    }


    @PostConstruct
    @Override
    public void start() {
        /* This would block any further progressing */
    }
}
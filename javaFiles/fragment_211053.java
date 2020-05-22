import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class Server {
    private Logger logger;
    private long id;

    public Server(long id, Object lock) {
        this.id=id;
        ThreadContext.put("ROUTINGKEY", "server"+id);
        synchronized(lock){
            logger = LogManager.getLogger(Constants.DYNAMIC_SERVERS);
        }
    }

    public void doStuff(){
        logger.info("Server "+ id +" did some stuff");
    }
}
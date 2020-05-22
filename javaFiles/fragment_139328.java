import com.mongodb.MongoClient;
import io.dropwizard.lifecycle.Managed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MongoClientManager implements Managed {
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoClientManager.class);
    private final MongoClient client;

    public MongoClientManager(MongoClient client) {
        this.client = client;
    }

    @Override
    public void start() throws Exception {
        LOGGER.info("MongoClient is starting up...");
    }

    @Override
    public void stop() throws Exception {
        LOGGER.info("MongoClient is being shut down...");
        client.close();
    }
}
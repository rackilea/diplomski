import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.UnknownHostException;

@Component
public class MongoClientWrapper {
    @Autowired
    private MongoClientURI mongoClientURI;

    private MongoClient mongoClient;

    @PostConstruct
    public void init() {
        mongoClient = getNewMongoClientInstance();
    }

    @PreDestroy
    public void beforeTearDown() {
        mongoClient.close();
    }

    public void resetConnectionPool() {
        mongoClient.close();
        mongoClient = getNewMongoClientInstance();
    }

    private MongoClient getNewMongoClientInstance() {
        MongoClient client = null;
        try {
            client = new MongoClient(mongoClientURI.getURI());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } finally {
            return client;
        }
    }
}
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Schedule;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.ObjectMessage;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;
import javax.jms.Connection;
import javax.jms.Queue;

//from imq.jar
import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

@Singleton
public class SyncNode {
    private ConnectionFactory _producerRequestFactory;
    private Connection _connection;
    private Session _session;
    private Queue _producerRequestMessageQueue;
    private MessageConsumer _consumer;

    @PostConstruct
    void init() {
        try {
            _producerRequestFactory = new ConnectionFactory();
            _producerRequestFactory.setProperty(ConnectionConfiguration.imqBrokerHostName, "localhost");
            _producerRequestFactory.setProperty(ConnectionConfiguration.imqBrokerHostPort, "56527"); //56527 is JMS_PROVIDER_PORT found in producer's domain.xml in domain config directory
            _connection = _producerRequestFactory.createConnection();
            _session = _connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            _producerRequestMessageQueue = _session.createQueue("ProducerRequestMessageQueue"); //name of the queue that the producer sends messages to.
            _consumer = _session.createConsumer(_producerRequestMessageQueue);
            _connection.start();
        } catch (JMSException ex) {
            //handle exception
        }
    }

    @PreDestroy
    void cleanup() {
        try {
            _consumer.close();
            _session.close();
            _connection.close();
        } catch (JMSException ex) {
            //handle exception
        }
    }

    @Schedule(hour = "*", minute = "*", second = "*/10", persistent = false)
    public void onMessage() {
        try {
            _connection.start(); 
            Message message = _consumer.receive();
            //handle message
        } catch (JMSException ex) {
           //handle exception
        }
    }
}
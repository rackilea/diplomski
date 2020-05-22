import java.util.Date;
import java.util.Hashtable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JmsProducerQueueClient {
    public static void main(String[] args) throws NamingException, JMSException {
        Connection connection = null;
        try {
            Context context = getInitialContext();
            ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("ConnectionFactory2");
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, QueueSession.AUTO_ACKNOWLEDGE);
            Queue queue = (Queue) context.lookup("Queue0");
            connection.start();
            MessageProducer producer = session.createProducer(queue);
            Message hellowWorldText = session.createTextMessage("Hello World! " + new Date());
            hellowWorldText.setStringProperty("StockSector", "Finance");
            producer.send(hellowWorldText);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://localhost:8208");
        Context context = new InitialContext(env);
        return context;
    }
}
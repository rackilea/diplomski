import java.util.Hashtable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JmsConsumerQueueClient {
    public static void main(String[] args) throws NamingException, JMSException {
        Connection connection = null;
        try {
            Context context = getInitialContext();
            ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("ConnectionFactory1");
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, QueueSession.AUTO_ACKNOWLEDGE);
            Queue queue = (Queue) context.lookup("Queue0");
            String selector = new String("(StockSector = 'Technology')");
            MessageConsumer consumer = session.createConsumer(queue, selector);
            connection.start();
            TextMessage hellowWorldText = (TextMessage) consumer.receive();

            System.out.println("> " + hellowWorldText + " | " + hellowWorldText.getText());

        } finally {
            if (connection != null) {
                connection.close();
            }
        }

    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://localhost:7001");
        Context context = new InitialContext(env);
        return context;
    }
}
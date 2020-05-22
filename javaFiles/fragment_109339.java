import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

public class MyContextListener implements ServletContextListener {
    public final static String ACTIVE_MQ_SESSION = "ActiveMQSession";
    public final static String ACTIVE_MQ_PRODUCER = "ActiveMQProducer";

    Logger logger = Logger.getLogger(this.getClass());
    private static final int ackMode = Session.AUTO_ACKNOWLEDGE;
    private static final boolean transacted = false;

    private static final String brokerUrl = "vm://localhost:61616";

    private Connection connection;
    private Session session;
    private MessageProducer producer;

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            this.producer.close();
            this.session.close();
            this.connection.close();
        } catch (JMSException e) {
            logger.warn("tearDown()", e);
        }

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                brokerUrl);

        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(transacted, ackMode);
            Destination destination = session.createQueue("queue");
            producer = session.createProducer(destination);

            ServletContext sc = sce.getServletContext();
            sc.setAttribute(ACTIVE_MQ_SESSION, session);
            sc.setAttribute(ACTIVE_MQ_PRODUCER, producer);
        } catch (JMSException e) {
            logger.warn("setup() failed to setup connection brokerUrl="
                    + brokerUrl);
        }
    }

}
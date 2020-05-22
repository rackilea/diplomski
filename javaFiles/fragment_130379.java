package queueFeed;

import dao.ProcmonDao;
import dao.EventDao;
import domain.Event;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;
import java.sql.SQLException;
import java.sql.Time;
import java.util.*;

public class QueueRunner {
    private ProcmonDao dao;
    private Connection connection;
    private String queueName;

    public QueueRunner() throws SQLException {
        dao = new EventDao();
    }

public void setConnection(String username, String password, String url) throws JMSException {
    ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(username, password, url);
    connection = factory.createConnection();
}

public void run() throws Exception {
    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    QueueBrowser browser = session.createBrowser(new ActiveMQQueue(queueName));

    List<String> ids = new ArrayList<>();
    int queueSize = 0;
    int counter = 0;
    connection.start();

    while (true) {
        Enumeration enumeration = browser.getEnumeration();
        if (queueSize < ids.size()) {
            while (enumeration.hasMoreElements()) {
                Message message = (Message) enumeration.nextElement();
                ids.remove(message.getJMSMessageID());
                counter++;
            }

            if (ids.size() > 0 && ids.size() > 0) {
                Iterator<String> iterator = ids.iterator();
                while (iterator.hasNext()) {
                    String messageId = iterator.next();
                    dao.insert(new Event("Queue", messageId, "UP", browser.getQueue().getQueueName(), new Time(new Date().getTime())));
                    iterator.remove();
                }
            }

            queueSize = counter;
            counter = 0;
        } else {

            while (enumeration.hasMoreElements()) {
                counter++;
                Message message = (Message) enumeration.nextElement();
                String id = message.getJMSMessageID();
                if (!ids.contains(id)) {
                    ids.add(id);
                    dao.insert(new Event("Queue", id, "UP", browser.getQueue().getQueueName(), new Time(new Date().getTime())));
                }
            }
            queueSize = counter;
            counter = 0;
        }
    }
}

public void setQueueName(String queueName) {
    this.queueName = queueName;
}

public String getQueueName() {
    return this.queueName;
}
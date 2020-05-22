import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class tibjmsMsgTopicProducer {

static String serverUrl = "localhost";
static String userName = "admin";
static String password = "admin";

public static void sendTopicMessage(String topicName, String messageStr) {

    Connection connection = null;
    Session session = null;
    MessageProducer msgProducer = null;
    Destination destination = null;

    try {
        TextMessage msg;

        System.out.println("Publishing to destination '" + topicName
                + "'\n");

        ConnectionFactory factory = new com.tibco.tibjms.TibjmsConnectionFactory(
                serverUrl);

        connection = factory.createConnection(userName, password);

        /* create the session */
        session = connection
                .createSession(javax.jms.Session.AUTO_ACKNOWLEDGE);

        /* create the destination */
        destination = session.createTopic(topicName);

        /* create the producer */
        msgProducer = session.createProducer(null);

        /* publish messages */
        /* create text message */
        msg = session.createTextMessage();

        /* set message text */
        msg.setText(messageStr);

        /* publish message */
        msgProducer.send(destination, msg);

        System.out.println("Published message: " + messageStr);

        /* close the connection */
        connection.close();

    } catch (JMSException e) {
        e.printStackTrace();
    }
}

/*-----------------------------------------------------------------------
 * main
 *----------------------------------------------------------------------*/
public static void main(String[] args) {
    tibjmsMsgTopicProducer.sendTopicMessage("topic1",
            "This is the message content !");
}
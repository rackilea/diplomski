import java.sql.Connection;
import oracle.AQ.AQAgent;
import oracle.AQ.AQDriverManager;
import oracle.AQ.AQQueue;
import oracle.AQ.AQQueueProperty;
import oracle.AQ.AQQueueTable;
import oracle.AQ.AQQueueTableProperty;
import oracle.AQ.AQSession;

/**
 *
 * @author alukasiewicz
 */
public class NewClass {

    public static void main(String[] args) throws Exception {
        Class.forName("oracle.AQ.AQOracleDriver");
        Connection con = ConnectionDefinition.getOracleConnection();
        AQSession aq_sess = AQDriverManager.createAQSession(con);
        AQQueueTableProperty qtable_prop;
        AQQueueProperty queue_prop;
        AQQueueTable q_table;
        AQQueue queue;
        AQAgent subs1, subs2;
        qtable_prop = new AQQueueTableProperty("SYS.AQ$_JMS_BYTES_MESSAGE");
        qtable_prop.setMultiConsumer(true);
        q_table = aq_sess.createQueueTable("jmsuser", "aq_table5", qtable_prop);
        queue_prop = new AQQueueProperty();
        queue = aq_sess.createQueue(q_table, "aq_queue5", queue_prop);
        System.out.println("Successful createQueue");
        System.out.println("Successful start queue");
        subs1 = new AQAgent("GREEN", "", 0);
        subs2 = new AQAgent("BLUE", "", 0);
        queue.addSubscriber(subs2, null);
        queue.addSubscriber(subs1, null);
        queue.start();
    }
}
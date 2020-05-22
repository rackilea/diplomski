public class Receiver implements MessageListener {

    static Connection conn;
    ActiveMQConnectionFactory factory;
    static Session sess;
    static MessageConsumer consumer;


    public Receiver() throws Exception {

        /*
         *  create a logTopic topic consumer
         */
        factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        conn = factory.createConnection();
        sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        conn.start();
        consumer = sess.createConsumer(sess.createTopic("logTopic"));
        consumer.setMessageListener(this);

    }

    public static void main(String[] args) throws Exception {

        Runtime.getRuntime().addShutdownHook(new Thread(new ShutDownListener(consumer, sess, conn)));
        new Receiver();
    }


    public void onMessage(Message message) {
        try {
            LoggingEvent event = (LoggingEvent) ((ActiveMQObjectMessage) message)
                    .getObject();

            /*
             * log on console and into a file
             */

            FileReceiver.logToFile(event);
            StdoutReceiver.logOnConsole(event);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
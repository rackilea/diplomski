public class Subscriber {

    public static void main(String[] args) throws Exception {
        Class.forName("oracle.AQ.AQOracleDriver");
        Connection con = ConnectionDefinition.getOracleConnection();
        TopicConnection tc_conn = AQjmsTopicConnectionFactory.createTopicConnection(con);
        TopicSession jms_sess = tc_conn.createTopicSession(true, Session.SESSION_TRANSACTED);
        tc_conn.start();
        Topic queueTopic = ((AQjmsSession) jms_sess).getTopic("jmsuser", "AQ_QUEUE5");
        TopicSubscriber subGreen =  (TopicSubscriber)((AQjmsSession) jms_sess).createDurableSubscriber(queueTopic, "GREEN");
        TopicSubscriber subRed =  (TopicSubscriber)((AQjmsSession) jms_sess).createDurableSubscriber(queueTopic, "RED");        
        Message msg = subGreen.receive(10);
        System.err.println("Start receiving message for green subscriber");
        while(msg != null){
              System.err.println("     GREEN recive message "+ ((BytesMessage)msg).readUTF());
              msg = subGreen.receive(10); // receive with timeout;
        }
        System.err.println("End receiving message for green subscriber");
        System.err.println("  ");        
        System.err.println("Start receiving message for red subscriber");
        BytesMessage byteMsg = (BytesMessage)msg;
        msg = subRed.receive(10);
        while(msg != null){
              System.err.println("     RED recive message "+ ((BytesMessage)msg).readUTF());
              msg = subRed.receive(10); // receive with timeout;
        }
           System.err.println("End receiving message for red subscriber");
        con.commit();
        tc_conn.close();
        con.close();

    }
}
public class Publisher {

        public static void main(String[] args) throws Exception {
            Class.forName("oracle.AQ.AQOracleDriver");
            Connection con = ConnectionDefinition.getOracleConnection();
            TopicConnection tc_conn =AQjmsTopicConnectionFactory.createTopicConnection(con);
            tc_conn.start();
            TopicSession jms_sess = tc_conn.createTopicSession(true, Session.SESSION_TRANSACTED);
            Topic queueTopic= ((AQjmsSession )jms_sess).getTopic("JMSUSER","AQ_QUEUE5");
            AQjmsTopicPublisher publisherAq = (AQjmsTopicPublisher)jms_sess.createPublisher(queueTopic);
            BytesMessage messAll = jms_sess.createBytesMessage();
            BytesMessage messOnlyForGreen = jms_sess.createBytesMessage();
            messAll.writeUTF("Message for all subscribers");
            messOnlyForGreen.writeUTF("Message only for green");
            publisherAq.publish(messAll);
            publisherAq.publish(messOnlyForGreen, new AQjmsAgent[]{new AQjmsAgent("GREEN", null)} );
            con.commit();
            tc_conn.close();
            con.close();                
        } 
    }
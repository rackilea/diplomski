/*the object you will be sent to consumer*/
  public class MSObject implements java.io.Serializable{
  ......
  }

  /*sending method*/
  private void sendObjectMessage() throws Exception {
        ActiveMQSession mysession = (ActiveMQSession) session;
        ObjectMessage msg = session.createObjectMessage();
        msg.setObject( new MSObject("first name","Jimmy") );
        msg.setJMSType(this.CMD_TYPE_MESSAGETYPE_OBJECT);
        producer.send(msg);
        if (transacted) {
            session.commit();
        }
        System.out.println("The object message has been sent to " + this.subject
                + " queue.");
        Thread.sleep(sleepTime);
    }
    /*receiving method*/
    public void onMessage(Message message) {

        if (message instanceof ObjectMessage) {
        System.out.println("recevied a Object Message");
        ObjectMessage msg = (ObjectMessage)message;
        MSObject obj = (MSObject)msg.getObject();
        System.out.println("info: ");
        System.out.println("key: "+obj.getKey());
        System.out.println("value: "+obj.getValue());
    }
    }
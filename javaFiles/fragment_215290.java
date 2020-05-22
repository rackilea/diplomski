@Singleton
@Transactional(value = TxType.REQUIRES_NEW)
public class ServiceLayer implements IServiceLayer {

    @Resource(mappedName="GenericJmsXA")
    public ConnectionFactory queueFactory; 

    private String QUEUE = "Queue";


    public void sendMessage(String message) throws Exception {

        MessageProducer qsender = null;

        Session qsession = null;

        Connection qcon = null;

        try{    
            qcon = this.queueFactory.createConnection();    
            qsession = qcon.createSession(true, QueueSession.AUTO_ACKNOWLEDGE);    
            Queue q = qsession.createQueue(QUEUE);    
            qsender = qsession.createProducer(q);    
            TextMessage tm = qsession.createTextMessage(message);    
            System.out.println("Before sending to Queue: Waiting for 5 seconds. " + QUEUE);    
            qsender.send(tm);    
            Thread.sleep(5000);    
            System.out.println("Message [" + tm.getText() + "] sent to Queue: " + QUEUE);
        }catch(Exception e){

            System.out.println("Exception : "+e.getMessage());

            e.printStackTrace();

        }

}
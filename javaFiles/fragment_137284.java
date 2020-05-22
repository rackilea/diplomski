@Stateful
public class AManagerBean implements ejb.AManagerRemote {
@Resource(mappedName = "jms/QueueConnectionFactory")
private ConnectionFactory queueConnectionFactory;
@Resource(mappedName = "jms/Queue")
private Queue queue;

private static int fineAmt;

......

static class AListener implements MessageListener{
    public void onMessage(Message message){
         .....
         fineAmt = msg.getInt("fineAmt"); 
        // I NEED FINEAMT TO SHOW IN MAIN CLASS

         .....
    }
}

public int returnFine(){
     return fineAmt;
 }
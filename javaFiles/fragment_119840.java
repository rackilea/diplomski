public class EMSQueueInfo implements QueueInfoProvider {

    private static Admin admin = new Admin();
    private QueueInfo queueInfo

    public EMSQueueInfo(String queueName){
        queueInfo = admin.getQueue(queueName);
    }

    public int getMessagesOnQueue() {
        return queueInfo.getMessagesOnQueue();
    }

}
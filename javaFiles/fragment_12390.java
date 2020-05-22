import java.util.ArrayList;
import java.util.List;

public class QueueSelection {

public List<queueCollection> initQueueCollection()
{
    queueCollection d1 = new queueCollection("QUEUE_A1", "QUEUE_A2", false);
    queueCollection d2 = new queueCollection("QUEUE_B1", "QUEUE_B2", false);
    queueCollection d3 = new queueCollection("QUEUE_C1", "QUEUE_C1", true);
    queueCollection d4 = new queueCollection("QUEUE_D1", "QUEUE_D2", true);
    List<queueCollection> list = new ArrayList<queueCollection>();
    list.add(d1);
    list.add(d2);
    list.add(d3);
    list.add(d4);

    return list;
}

public void printQueueCollection(List<queueCollection> queueList)
{
    for(queueCollection queue : queueList)
    {
        System.out.printf("QueueName1=[%s], QueueName2=[%s] \n",queue.getQueueName1(),queue.getQueueName2());
    }
}
}
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

public static void main(String[] args) {
    QueueSelection selection = new QueueSelection();
    // Get queueCollection list
    List<queueCollection> queueList = selection.initQueueCollection();

    // Print List
    selection.printQueueCollection(queueList);

    /*
     * Map example
     */
    Map<String, List<queueCollection>> map = new HashMap<String, List<queueCollection>>();
    // Put entire collection into this map
    map.put("QUEUE", queueList);

    /*
     * Iterate the Map to find a collection with name 'QUEUE_A1 '
     */

    queueCollection particularCollection = null;

    for (queueCollection collection : map.get("QUEUE")) {
        if ("QUEUE_A1".equals(collection.getQueueName1())
                && "QUEUE_A2".equals(collection.getQueueName2())) {
            particularCollection = collection;
        }
    }

    // /Print Names using Particular Collection, which is found above.

    if (null == particularCollection) {
        System.out.println("No Particular collection is found!");
    } else {
        System.out.println("\n Particular collection is found from entire collection, its value is as follows:!");
        System.out.printf("[Name1]=>%s , [Name2]=>%s",
                particularCollection.getQueueName1(),
                particularCollection.getQueueName2());
    }

}
}
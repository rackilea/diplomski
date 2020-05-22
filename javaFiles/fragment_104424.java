public class QueueManager {

    private Map<String, List<Pcb>> queues = new HashMap<String, List<Pcb>>();

    public boolean addQueue(String queueName) {
        if (queues.containsKey(queueName)) {
            // There is already a queue with that name
            return false;
        } else {
            queues.put(queueName, new ArrayList<Pcb>());
            return true;
        }
    }
}
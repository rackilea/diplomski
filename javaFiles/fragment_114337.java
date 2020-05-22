public class NodeTask implements Callable<Object>, HazelcastInstanceAware, Serializable {

    private transient HazelcastInstance hazelcastInstance;

    public void setHazelcastInstance(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    public Object call() throws Exception {

        Object returnableObject = "testData";

        //Do all the IO operations here and set the returnable object

        System.out.println("Running the NodeTask on a Hazelcast Node: " + hazelcastInstance.getName());

        return returnableObject;
    }
}
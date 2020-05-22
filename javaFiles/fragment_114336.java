public class WorkerNode {

    public static void main(String[] args){

        /*
        Create a new Hazelcast node.
        Get the configurations from Hazelcast.xml in classpath or default one from jar
         */
        HazelcastInstance workerNode = Hazelcast.newHazelcastInstance();

        System.out.println("*********** Started a WorkerNode ***********");
    }

}
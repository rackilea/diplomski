public class Driver {

    public static void main(String[] args) throws Exception {

        HazelcastInstance client = HazelcastClient.newHazelcastClient();

        IExecutorService executor = client.getExecutorService("executor");
        Map<Member, Future<Object>> result = executor.submitToAllMembers(new NodeTask());

        for (Future<Object> future : result.values()) {
            /*
            Aggregation logic goes here.
             */
            System.out.println("Returned data from node: " + future.get());
        }

        client.shutdown();

        System.exit(0);
    }
}
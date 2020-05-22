public class EchoExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Config config = new Config();
        HazelcastInstance instance1 = Hazelcast.newHazelcastInstance(config);
        HazelcastInstance instance2 = Hazelcast.newHazelcastInstance(config);
        ExecutorService executorService = instance1.getExecutorService("exec1");
        Future<String> future = executorService.submit(new Echo());
        System.out.println(future.get());

    }

    static class Echo implements HazelcastInstanceAware, Serializable, Callable<String> {
        transient HazelcastInstance localInstance;

        public String call() throws Exception {
            return localInstance.toString();
        }

        @Override
        public void setHazelcastInstance(HazelcastInstance hazelcastInstance) {
            this.localInstance = hazelcastInstance;
        }
    }

}
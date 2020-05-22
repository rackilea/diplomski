public class TestHazelCast {

public static void main(String[] args) {

    Config cfg = new Config();
    HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);
    IExecutorService exec = instance.getExecutorService("exec");

    for (int i = 0 ; i < 7; i++){
        exec.execute(new myRunnable());
    }

}
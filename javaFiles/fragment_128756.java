public class PrivateEnum {

    public interface Worker {
        void doSomething();
    }

    static private enum Elvis implements Worker {
        INSTANCE;
        @Override public void doSomething() {
            System.out.println("Thank you! Thank you very much!");
        }
    }

    public Worker getWorker() {
        return Elvis.INSTANCE;
    }
}
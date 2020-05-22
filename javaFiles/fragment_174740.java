/**
 * @author @SotiriosDelamanolis 
 * see https://stackoverflow.com/a/19405498/2587435
 */
public class Test {
    public static void main(String[] args) throws  Exception {
        new Test().doWork(new Callback() { // implementing class            
            @Override
            public void call() {
                System.out.println("callback called");
            }
        });
    }

    public void doWork(Callback callback) {
        System.out.println("doing work");
        callback.call();
    }

    public interface Callback {
        void call();
    }
}
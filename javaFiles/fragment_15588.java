import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ChainedAsyncTest {

    public static void main(String[] args) throws InterruptedException {
        ChainedAsyncTest t = new ChainedAsyncTest();
        ExecutorService e = Executors.newFixedThreadPool(1);
        e.invokeAll(Arrays.asList(
            t.call("/something", t.somethingCallback),
            t.call("/something/else", t.somethingElseCallback),
            t.call("/yet/another/thing", t.yetAnotherThingCallback),
            t.allDone()));
    }

    private Callback somethingCallback = new Callback() {
        @Override
        public void onComplete(String data) {
            updateUi("something", data);
        }
    };

    private Callback somethingElseCallback = new Callback() {
        @Override
        public void onComplete(String data) {
            updateUi("somethingElse", data);
        }
    };

    private Callback yetAnotherThingCallback = new Callback() {
        @Override
        public void onComplete(String data) {
            updateUi("yetAnotherThing", data);
        }
    };

    private Callable<Void> call(
        final String key, final Callback callback) {
        return new Callable<Void>() {
            @Override
            public Void call() {
                get(key, callback);
                return null;
            }
        };
    }

    private Callable<Void> allDone() {
        return new Callable<Void>() {
            @Override
            public Void call() {
                System.out.println("allDone");
                return null;
            }
        };
    }



    interface Callback
    {
        void onComplete(String data);
    }
    private void get(String string, Callback callback) {
        System.out.println("Get "+string);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        callback.onComplete("result of "+string);
    }
    private void updateUi(String string, String data) {
        System.out.println("UpdateUI of "+string+" with "+data);
    }

}
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public interface FooService {
        public void foo();
    }

    public static class DelayCalculator {
        public long nextTime() { // ... };
    }
    public static class FooTask extends TimerTask {

        FooService fooSvc;

        public FooTask(FooService foos) {
            fooSvc = foos;
        }

        @Override
        public void run() {
            fooSvc.foo();

            TIMER.schedule(new FooTask(fooSvc), DELAYCALC.nextTime());
        }
    }

    private static final Timer TIMER = new Timer();

    private static final DelayCalculator DELAYCALC = new DelayCalculator();

    public static void main(String[] args) {
        FooTask fooT = new FooTask(() -> System.out.println("Foo"));
        TIMER.schedule(fooT, 0);
    }
}
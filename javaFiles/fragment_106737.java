import org.apache.commons.lang3.time.StopWatch;

public class Application {

    public static void main(String[] args) {
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        stopwatch.stop();
        long timeTaken = stopwatch.getTime();
        System.out.println(timeTaken);
    }
}
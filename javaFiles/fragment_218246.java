import java.text.ParseException;
import java.util.concurrent.TimeUnit;


public class WaitAndExecute {

    public static void main(String[] args) throws InterruptedException, ParseException {

        long startTime = System.nanoTime();

        long endTime = startTime;
        long durationInSeconds = 0;
        long durationInNano = 0;
        while(durationInSeconds<10) {
            methodToTime();
            System.out.println("2 seconds");
            endTime = System.nanoTime();
            durationInNano = (endTime - startTime); // Total execution time in nano seconds
            durationInSeconds = TimeUnit.NANOSECONDS.toSeconds(durationInNano); // Total execution time in seconds

            if(durationInSeconds>=10) {
                System.out.println("10 seconds done");
                break;
            }

        }
        System.out.println(durationInSeconds);
    }

    private static void methodToTime() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
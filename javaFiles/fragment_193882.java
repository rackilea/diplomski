import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public final class Answer {
    private static final int FIVE_SECONDS = 5 * 1000;
    private static final int TWO_SECONDS = 2 * 1000;

    public static void main(String... args) {
        // this list contains the values that the producer will add to and the consumer will pull from
        final List<Long> theList = new ArrayList<>();

        // consumes all values found in theList
        new Timer("consumer").scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                final List<Long> copy;
                synchronized (theList) {
                    // we make a copy and clear theArray as quickly as possible in 
                    // order to not block the producer for too long
                    copy = new ArrayList<>(theList);
                    theList.clear();
                }

                System.out.println("copy = " + copy);
            }
        }, 1, FIVE_SECONDS);

        // adds the current time in ms to theList every 2 seconds
        new Timer("producer").scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                synchronized (theList) {
                    theList.add(System.currentTimeMillis());
                }
            }
        }, 1, TWO_SECONDS);
    }
}
import java.util.Random;
import java.util.Timer;

public class LoopTest {

    private final static long desiredTime = 1000;

    public static void main(String[] args) {

        final float[] input = new float[512];

        final Random rand = new Random();
        for(int i = 0; i < input.length; ++i) {
            input[i] = rand.nextFloat();
        }

        final Timer timer = new Timer();

        final LoopTask task = new LoopTask(input);

        double interval = ((double)desiredTime/((double)input.length));
        long period = (long)Math.ceil(interval);

        final long t1 = System.currentTimeMillis();

        timer.scheduleAtFixedRate(task, 0, period);

        while(!task.isDone()) {
            try {
                Thread.sleep(50);
            } catch(final InterruptedException i) {
                //Meh
            }
        }

        final long t2 = System.currentTimeMillis();

        timer.cancel();

        System.out.println("Ended up taking " + (t2 - t1) + " ms");

    }

}
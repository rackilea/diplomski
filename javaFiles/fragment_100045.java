import java.util.TimerTask;

public class LoopTask extends TimerTask {

    private final float[] input;
    private int index = 0;
    private boolean done = false;

    public LoopTask(final float[] input) {
        this.input = input;
    }

    @Override
    public void run() {

        if(index == input.length) {
            done = true;
        } else {
            //TODO: actual processing goes here
            System.out.println("Element " + index + ": " + input[index]);
            ++index;
        }

    }

    public boolean isDone() {
        return done;
    }

}
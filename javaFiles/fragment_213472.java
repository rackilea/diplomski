public class TimerWatch {
    private long lastClick=0;

    public long tick() {
        long c = System.nanoTime();

        long result = c-lastClick;
        lastClick = c;

        return result;
    }
}
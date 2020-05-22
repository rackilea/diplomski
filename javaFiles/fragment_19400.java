public class StopWatch {

    private double startTime;

    private double endTime;

    public long start() {

        startTime = System.currentTimeMillis();

        return startTime;
    }

    public long stop() {

        endTime = System.currentTimeMillis();

        return endTime;

    }

    public double getElapsedTime(endTime, startTime) {
        return endTime - startTime;
    }
}
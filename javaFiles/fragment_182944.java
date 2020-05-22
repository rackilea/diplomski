public class WorkItem implements Runnable {
    private long startTime;
    private long runTime;
    private int workItemNumber;

    public WorkItem(long startTime, int workItemNumber) {
        this.startTime = startTime;
        this.workItemNumber= workItemNumber;
    }

    @Override
    public void run() {
        System.out.println("WorkItem started: " + workItemNumber + " Queued at: " + startTime);
        runTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - runTime < 10000) {
        }
        System.out.println("WorkItem done: " + workItemNumber);
    }
}
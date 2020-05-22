public class Test {

public void startExecution() {
Queue<String> runQ = new LinkedList<>();
ThreadPool threadPool = new ThreadPool(threadCount,timeOut);
while (!runQ.isEmpty()) {
    String TaskName = runQ.remove();
    Task t = new Task(TaskName);
    threadPool.execute(t, TaskName);

}
if (threadPool.awaitTermination(timeOut, TimeUnit.MINUTES)) {
    System.out.println("[CONTROL: ALL TEST TASKS COMPLETED SUCCESSFULLY.]");
} else {
    System.out.println("[CONTROL: ALL THE TEST TASKS DID NOT COMPLETE SUCCESSFULLY IN STIPULATED TIME. FORCEFULLY FINALIZING.]");
    threadPool.shutdownNow();

}
}
}
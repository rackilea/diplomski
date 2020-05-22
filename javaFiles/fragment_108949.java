public class ThreadPool extends ThreadPoolExecutor {

public ThreadPool(int threadCount, long keepAliveTime) {
    super(threadCount, threadCount, keepAliveTime, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
}

final String CTask = "TaskC";
Map<Runnable, String> TaskPool = new HashMap<>();
Queue<Runnable> TaskCList = new LinkedList<>();

@Override
protected synchronized void afterExecute(Runnable r, Throwable t) {
    super.afterExecute(r, t);
    System.out.println(TaskPool.get(r) + "Finished");
    if (TaskPool.containsKey(r)) {
        TaskPool.remove(r);
    }
    if (TaskCList.isEmpty()) {
        super.shutdown();
    }
    if (!TaskPool.containsValue(CTask) && !TaskCList.isEmpty()) {
        if (super.getActiveCount() < super.getCorePoolSize()) {
            System.out.println("Trying to execute Other C Tasks");
            Runnable ieRun = TaskCList.remove();
            super.execute(ieRun);
            TaskPool.put(ieRun, CTask);
        }
    }
}

public synchronized void execute(Runnable command, String TaskType) {
    if (TaskPool.containsValue(TaskType)
            && TaskType.equalsIgnoreCase(CTask)) {
        System.out.println("Another Instance of TaskC Running");
        System.out.println("Added for future Execution");
        TaskCList.add(command);
    } else {
        System.out.println("Adding " + TaskType + " to execution");
        TaskPool.put(command, TaskType);
        super.execute(command);
    }
}
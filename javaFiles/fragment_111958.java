public MyTask implements Runnable {
    private String id;
    private Map<String, MyTask> mapTasks;

    public MyTask(String id, Map<String, MyTask> mapTasks) {
        this.id = id;
        this.mapTasks = mapTasks;
    }

    public void run() {
         synchronized(mapTasks) {
             mapTasks.put(id, this);
         }

         ...

         synchronized(mapTasks) {
             mapTasks.remove(id);
         }
    }
}


// Create a map of tasks
Map<String, MyTask> mapTasks = new HashMap<String, MyTask>();

// How to create tasks
MyTask myTask1 = new MyTask("task1", mapTasks);
MyTask myTask2 = new MyTask("task2", mapTasks);

executorService.execute(myTask1);
executorService.execute(myTask2);

....
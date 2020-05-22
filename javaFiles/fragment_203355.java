private static final CopyOnWriteArrayList<String> runningTasks  = new CopyOnWriteArrayList<>();


public void doSomethingSyncedByInput(String input) {

    String lock;
    int index;

    synchronized (runningTasks) {
        index = runningTasks.indexOf(input);
        if (index >= 0) {
            // get currently available lock object
            lock = runningTasks.get(index);
        } else {
            // add a reference on tasks list
            lock = new String(input);
            runningTasks.add(lock);
        }
    }

    synchronized (lock) {
        if(!runningTasks.contains(lock)){
            runningTasks.add(lock);
        }

        doSomething(input);

        index = runningTasks.indexOf(lock);
        if(index >= 0)
            runningTasks.remove(index);
    }
}
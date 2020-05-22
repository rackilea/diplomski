BlockingQueue<WorkUnit> workQueue = new LinkedBlockingQueue<WorkUnit>();
...
// add work units to the work queue
for (int i = 0; i < 1000; i++) {
    // add work to the queue
    workQueue.put(new WorkUnit(i));
}

// the MyRunnable above can then be modified like this:
    ...
    public void run() {
        while (!done) {
            WorkUnit workUnit = workQueue.take();
            // use MyRunnable socket or channel and do the WorkUnit
        }
    }
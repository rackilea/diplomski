private class UI {

    private Queue<Runnable> operationQueue = new LinkedList<Runnable>();

    public Queue<Runnable> getOperationQueue() {
        return operationQueue();
    }

    // ...
}
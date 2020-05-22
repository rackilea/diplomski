task.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED,
    new EventHandler<WorkerStateEvent>() {
    @Override
    public void handle(WorkerStateEvent t) {
        MyObject result = task.getValue();
        // now do something with result
    }
});
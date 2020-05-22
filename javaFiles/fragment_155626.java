final Task<MyDataType> task = new Task<MyDataType>() {
    @Override
    public MyDataType call() throws Exception {
        // do work here...
        return result ;
    }
};

task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
    @Override
    public void handle(WorkerStateEvent event) {
        MyDataType result = task.getValue(); // result of computation
        // update UI with result
    }
});

Thread t = new Thread(task);
t.setDaemon(true); // thread will not prevent application shutdown
t.start();
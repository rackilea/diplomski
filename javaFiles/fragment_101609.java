task.setOnFailed(new EventHandler<WorkerStateEvent>(){
    @Override
    public void handle(WorkerStateEvent event) {
        Throwable th = task.getException();
        System.out.println("Error on Task:"+th.getMessage());
        th.printStackTrace();
    }
});
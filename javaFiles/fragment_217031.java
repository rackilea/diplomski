ExampleTask task = new ExampleTask(new ExampleTask.TaskListener() {
    @Override
    public void onFinished(boolean success) {
        // Do whatever you want with the result
    }
});
task.execute();
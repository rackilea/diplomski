MyAsyncTask task = new MyAsyncTask();
task.execute();
task.setOnFinishListener(new MyAsyncTask.onFinishListener(){
    @Override
    public void onFinish(variableType myResult){
        // The task has finished and you can now use the result
    }
});
MyAsyncTask task = new MyAsyncTask();
private void createNewTask(Object o) {
  if(task.getStatus() == AsyncTask.Status.RUNNING) {
    //Do Something?
  } else {
    task = new MyAsyncTask();
    task.execute(arg0);
  }
}
@Override
public void run() {
  statusHandler.TaskRunning(this);
  try {
    super.run();
  finally {
    statusHandler.TaskCompleted(this);
  }
}
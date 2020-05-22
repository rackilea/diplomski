interface MyProgressMonitor
{
  public void beginTask(String name, int totalWork);

  public void done();

  public boolean isCanceled();

  public void worked(int work);
}
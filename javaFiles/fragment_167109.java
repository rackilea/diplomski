class EclipseMyProgressMonitor implements MyProgressMonitor
{
  private final IProgressMonitor monitor;

  EclipseMyProgressMonitor(IProgressMonitor theMonitor)
  {
    monitor = theMonitor;
  }

  public void beginTask(String name, int totalWork)
  {
    monitor.beginTask(name, totalWork);
  }

  public void done()
  {
    monitor.done();
  }

  public boolean isCanceled()
  {
    return monitor.isCanceled();
  }

  public void worked(int work)
  {
    monitor.worked(work);
  }
}
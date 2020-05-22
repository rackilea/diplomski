public class MyJob extends Job {
  private JobLogic logic;
  public MyJob(JobLogic logic) {
    this.logic = logic;
  }
  IStatus run(IProgressMonitor monitor) {
    return logic.run(monitor);
  }
}

public class MyUIJob extends UIJob {
  private JobLogic logic;
  public MyUIJob(JobLogic logic) {
    this.logic = logic;
  }
  IStatus runInUIThread(IProgressMonitor monitor) {
    return logic.run(monitor);
  }
}

public class JobLogic {
  IStatus run(IProgressMonitor monitor) {
    // logic goes here ...
  }
}
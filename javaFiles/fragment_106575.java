public class RunOnReplication extends Job {
    public RunOnReplication(String name) {
      super(name);
    }

    @Override
    public IStatus run(IProgressMonitor arg0) {
        try {
            NotesThread.sinitThread();
            Session session = NotesFactory.createSessionWithFullAccess();
            //do your stuff here
        } catch (Exception e) {
            // do your error handling here
        } finally {
            NotesThread.stermThread();
        }
    return Status.OK_STATUS;
   }
}
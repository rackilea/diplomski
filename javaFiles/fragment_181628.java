public void run(boolean fork, boolean cancelable,
         IRunnableWithProgress runnable) throws InvocationTargetException,
         InterruptedException {
     setCancelable(cancelable);
     try {
         aboutToRun();
         // Let the progress monitor know if they need to update in UI Thread
         progressMonitor.forked = fork;
         ModalContext.run(runnable, fork, getProgressMonitor(), getShell()
                 .getDisplay());
     } finally {
         finishedRun();  // this is line 498
     }
}
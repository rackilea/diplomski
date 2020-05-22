final IWorkbench workbench = PlatformUI.getWorkbench();
 workbench.getDisplay().asyncExec(new Runnable() {
   public void run() {
     IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
     if (window != null) {
       // do something
     }
   }
 });
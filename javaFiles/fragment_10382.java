// Typed using Void because runProgram() has no return value.
new SwingWorker<Void, Void>() {
  protectedVoid doInBackground() {
    runProgram();
    return null; // runProgram() doesn't return anything so return null.
  }

  protected void done() {
    // Called on the EDT when the background computation has completed.
    // Could insert code to update UI here.
  }  
}.execute()
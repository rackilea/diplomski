getShell().addTraverseListener(new TraverseListener() {
   @Override
   public void keyTraversed(TraverseEvent event) {
     if (event.detail == SWT.TRAVERSE_RETURN) {
        event.doit = false;
     }
   }
});
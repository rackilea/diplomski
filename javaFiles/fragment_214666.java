@Test
public void asyncTest() {
   AsyncScope scope = new AsyncScope() {
      protected void doAsync() {
         // Any asynchronous code
         AWorkflowImpl w = new AWorkflowImpl(workflowFactory);
         w.execute(); // whatever execute method of the workflow
      }
   };
   scope.eventLoop();
}
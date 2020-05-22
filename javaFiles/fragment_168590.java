public void addListenerToCopyCommand() {
    ICommandService commandService = (ICommandService) PlatformUI
      .getWorkbench().getAdapter(ICommandService.class);
    Command defaultCopyCommand = commandService
      .getCommand(org.eclipse.ui.IWorkbenchCommandConstants.EDIT_COPY);
    defaultCopyCommand.addExecutionListener(new MyCopyListener());
}

public class MyCopyListener implements IExecutionListener {
        @Override
        public void preExecute(String commandId, ExecutionEvent event) {
            // do nothing
        }

        @Override
        public void postExecuteSuccess(String commandId, Object returnValue) {

            // !!! Do stuff with the copied things here !!!!

            System.out.println("copy command has executed");

        }

        @Override
        public void postExecuteFailure(String commandId,
                ExecutionException exception) {
            // do nothing
        }

        @Override
        public void notHandled(String commandId, NotHandledException exception) {
            // do nothing
        }    
}
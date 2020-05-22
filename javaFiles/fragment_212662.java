public class CallMyViewPart extends AbstractHandler implements IHandler {      

    @Override      
    public Object execute(ExecutionEvent event) throws ExecutionException {      
        Shell shell = HandlerUtil.getActiveWorkbenchWindow(event).getShell();      
        IWorkbenchPage page = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();
        try {
        page.showView("somedomain.mainViewpart");
    } catch (PartInitException e) {
        e.printStackTrace();
    }

    return null;      
    }      
}
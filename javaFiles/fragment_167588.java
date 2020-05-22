@Execute
public void execute(final ExecutionEvent event) throws PartInitException
{
    final IWorkbenchWindow activeww = HandlerUtil.getActiveWorkbenchWindow(event);
    final IWorkbenchPage activePage = activeww.getActivePage();

    activePage.showView("com.sample.application.part.other");
}
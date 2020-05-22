@Execute
public void execute(final EPartService partService) throws PartInitException
{
    final IWorkbenchWindow activeww = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    IWorkbenchPage activePage = activeww.getActivePage();

    activePage.showView("com.sample.application.part.other");
}
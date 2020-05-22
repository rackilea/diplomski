final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
final IWorkbenchPage page = window.getActivePage();
try {
    if (page.getActivePart() != null) {
    viewTitle = page.getActivePart().getTitle();
    IViewPart view = page.showView(MainView.ID)  //id de la view in plugin.xml
    page.hideView(page.findView(SitesView.ID));
    }
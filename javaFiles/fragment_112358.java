//Add this code to an IStartup.earlyStartup() method
final IPartListener partListener = new IPartListener() {
    @Override
    public void partOpened(IWorkbenchPart part) {
        if (part instanceof WebBrowserEditor)
        {
            WebBrowserEditor editor = (WebBrowserEditor) part;

            try {
                Field webBrowser = editor.getClass().getDeclaredField("webBrowser");
                webBrowser.setAccessible(true);
                BrowserViewer viewer = (BrowserViewer)webBrowser.get(editor);

                Field browser = viewer.getClass().getDeclaredField("browser");
                browser.setAccessible(true);
                Browser swtBrowser = (Browser) browser.get(viewer);

                swtBrowser.addLocationListener(new LocationListener() {
                    @Override
                    public void changed(LocationEvent event) {
                        System.out.println(event.location);
                    }
                });
            } catch (Exception e) {
            }
        }
        else if (part instanceof WebBrowserView)
        {
            WebBrowserView view = (WebBrowserView) part;

            try {
                Field webBrowser = editor.getClass().getDeclaredField("viewer");
                webBrowser.setAccessible(true);
                BrowserViewer viewer = (BrowserViewer)webBrowser.get(view);

                Field browser = viewer.getClass().getDeclaredField("browser");
                browser.setAccessible(true);
                Browser swtBrowser = (Browser) browser.get(viewer);

                swtBrowser.addLocationListener(new LocationListener() {
                    @Override
                    public void changed(LocationEvent event) {
                        System.out.println(event.location);
                    }
                });
            } catch (Exception e) {
            }
        }
    }
    ...
};

final IPageListener pageListener = new IPageListener() {
    @Override
    public void pageOpened(IWorkbenchPage page) {
        page.addPartListener(partListener);
    }
    ...
};

final IWindowListener windowListener = new IWindowListener() {
    @Override
    public void windowOpened(IWorkbenchWindow window) {
        window.addPageListener(pageListener);
    }
    ...
};


IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

if (activeWindow != null)
{
    IWorkbenchPage activePage = activeWindow.getActivePage();

    if (activePage != null)
    {
        activePage.addPartListener(partListener);
    }
    else
    {
        activeWindow.addPageListener(pageListener);
    }
}
else
{
    for (IWorkbenchWindow window : PlatformUI.getWorkbench().getWorkbenchWindows())
    {
        for (IWorkbenchPage page : window.getPages()) {
            page.addPartListener(partListener);
        }
        window.addPageListener(pageListener);
    }

    PlatformUI.getWorkbench().addWindowListener(windowListener);
}
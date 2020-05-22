public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("Main Window");
    shell.setLayout(new FillLayout());
    final Browser browser;
    try
    {
        browser = new Browser(shell, SWT.NONE);
    }
    catch (SWTError e)
    {
        System.out.println("Could not instantiate Browser: " + e.getMessage());
        display.dispose();
        return;
    }
    initialize(display, browser);
    shell.open();
    browser.setUrl("http://www.w3schools.com/html/tryit.asp?filename=tryhtml_links_target");
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}

/* register WindowEvent listeners */
static void initialize(final Display display, Browser browser)
{
    browser.addOpenWindowListener(e ->
    {
        Shell shell = new Shell(display);
        shell.setText("New Window");
        shell.setLayout(new FillLayout());
        Browser browser1 = new Browser(shell, SWT.NONE);
        initialize(display, browser1);
        e.browser = browser1;
    });
    browser.addVisibilityWindowListener(new VisibilityWindowListener()
    {
        @Override
        public void hide(WindowEvent e)
        {
            Browser browser = (Browser) e.widget;
            Shell shell = browser.getShell();
            shell.setVisible(false);
        }

        @Override
        public void show(WindowEvent e)
        {
            Browser browser = (Browser) e.widget;
            final Shell shell = browser.getShell();
            if (e.location != null) shell.setLocation(e.location);
            if (e.size != null)
            {
                Point size = e.size;
                shell.setSize(shell.computeSize(size.x, size.y));
            }
            shell.open();
        }
    });
    browser.addCloseWindowListener(e ->
    {
        Browser browser1 = (Browser) e.widget;
        Shell shell = browser1.getShell();
        shell.close();
    });
}
public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("Main Window");
    shell.setLayout(new FillLayout());

    TabFolder tabFolder = new TabFolder(shell, SWT.BORDER);

    addNewBrowser(tabFolder, "<a href='http://www.google.co.uk' target='_blank'>Click here!</a>");

    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}

private static Browser addNewBrowser(TabFolder folder, String html)
{
    TabItem item = new TabItem(folder, SWT.NONE);
    Composite c = new Composite(folder, SWT.NONE);
    item.setControl(c);
    c.setLayout(new FillLayout());

    Browser browser = new Browser(c, SWT.NONE);

    if (html != null)
    {
        browser.setText(html);
        item.setText("Original tab");
    }
    else
    {
        item.setText("New tab");
    }

    browser.addOpenWindowListener(e ->
    {
        e.browser = addNewBrowser(folder, null);
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

    folder.setSelection(item);

    return browser;
}
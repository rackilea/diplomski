private static Browser browser;

public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);

    browser = new Browser(shell, SWT.NONE);
    browser.setBounds(5, 5, 600, 600);

    browser.addListener(SWT.Close, new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            System.out.println("closing");
            Browser browser = (Browser) event.widget;
            Shell shell = browser.getShell();
            shell.close();
        }
    });

    new CustomFunction(browser, "theJavaFunction");

    browser.setText("<a href=\"javascript:theJavaFunction();\">Close this Window</a>");
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}

private static class CustomFunction extends BrowserFunction
{
    CustomFunction(Browser browser, String name)
    {
        super(browser, name);
    }

    @Override
    public Object function(Object[] arguments)
    {
        System.out.println("theJavaFunction() called from javascript");
        Shell shell = browser.getShell();
        shell.close();
        return null;
    }
}
public class StackOverflow
{

    public static void main(String[] args)
    {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());
        shell.setBounds(10, 10, 800, 800);

        final Browser browser;
        try
        {
            browser = new Browser(shell, SWT.NONE);
        }
        catch (SWTError e)
        {
            System.out.println("Could not instantiate Browser: "
                    + e.getMessage());
            display.dispose();
            return;
        }
        browser.setText("<a href='' onclick='getdatafromjava2()'>Click here</a>");
        final BrowserFunction function = new CustomFunction(browser,
                "getdatafromjava2");

        browser.addProgressListener(new ProgressAdapter()
        {
            @Override
            public void completed(ProgressEvent event)
            {
                browser.addLocationListener(new LocationAdapter()
                {
                    @Override
                    public void changed(LocationEvent event)
                    {
                        browser.removeLocationListener(this);
                        System.out
                                .println("left java function-aware page, so disposed CustomFunction");
                        function.dispose();
                    }
                });
            }
        });

        shell.open();
        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}

class CustomFunction extends BrowserFunction
{

    CustomFunction(Browser browser, String name)
    {
        super(browser, name);
    }

    @Override
    public Object function(Object[] arguments)
    {
        System.out.println("theJavaFunction() called from javascript with args:");

        Display display = Display.getCurrent();
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());
        Browser browser2 = new Browser(shell, SWT.NONE);
        // browser2.setText(createHTML ());
        browser2.setText("SUCCESS");
        shell.setText("New Window");
        shell.open();
        return null;
    }
}
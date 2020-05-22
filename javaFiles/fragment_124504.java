public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    final Spinner spinner = new Spinner(shell, SWT.NONE);
    spinner.setMaximum(100);
    spinner.setMinimum(0);
    spinner.setIncrement(10);

    spinner.addListener(SWT.Verify, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            if(arg0.keyCode != 0)
            {
                System.out.println("Value edited");
                arg0.doit = false;
            }
            else
            {
                System.out.println("Button pressed");
            }
        }
    });

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }
    display.dispose();
}
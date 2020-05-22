public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));

    Text text = new Text(shell, SWT.BORDER);
    text.addListener(SWT.KeyDown, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            if ((e.stateMask & SWT.CTRL) == SWT.CTRL && e.keyCode == 'c')
            {
                e.doit = false;
            }
        }
    });

    shell.setSize(1000, 400);
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}
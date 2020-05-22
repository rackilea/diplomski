public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    Text text = new Text(shell, SWT.BORDER);
    text.setText("Read only");

    text.addListener(SWT.Verify, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            e.doit = false;
        }
    });

    shell.pack();
    shell.setSize(600, 60);
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}
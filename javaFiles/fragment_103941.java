public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    final Text text = new Text(shell, SWT.BORDER);
    text.addListener(SWT.Traverse, new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            if(event.detail == SWT.TRAVERSE_RETURN)
            {
                System.out.println("Enter pressed");
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
public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    final Text text = new Text(shell, SWT.BORDER);
    text.setVisible(false);

    final Runnable timer = new Runnable()
    {
        public void run()
        {
            if (text.isDisposed())
                return;

            text.setVisible(true);
        }
    };

    display.timerExec(5000, timer);

    shell.pack();
    shell.setSize(400, 200);
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
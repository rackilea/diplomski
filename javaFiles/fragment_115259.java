public static void main(String[] args)
{
    final Display display = new Display();
    Shell shell = new Shell();
    shell.setLayout(new FillLayout());

    final Label status = new Label(shell, SWT.NONE);
    status.setText("0");

    display.timerExec(100, new Runnable()
    {
        int i = 1;

        @Override
        public void run()
        {
            if(!status.isDisposed())
                status.setText(i++ + "");

            display.timerExec(100, this);
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
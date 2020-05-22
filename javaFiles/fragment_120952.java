public static void main(String[] args)
{
    final Display display = new Display();

    Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(1, false));

    final DateTime date = new DateTime(shell, SWT.DATE);
    final DateTime time = new DateTime(shell, SWT.TIME);

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Change date");
    button.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            date.setDate(1999, 0, 1);
            time.setHours(0);
            time.setMinutes(0);
            time.setSeconds(0);
        }
    });

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
}
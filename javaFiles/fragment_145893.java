public static void main(String[] args)
{
    final Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout(SWT.VERTICAL));

    final Text first = new Text(shell, SWT.BORDER);
    final Text second = new Text(shell, SWT.BORDER);
    final Button button = new Button(shell, SWT.PUSH);
    button.setText("disabled");
    button.setEnabled(false);

    Listener listener = new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            String firstString = first.getText();
            String secondString = second.getText();

            button.setEnabled(!isEmpty(firstString) && !isEmpty(secondString));
            button.setText(button.isEnabled() ? "enabled" : "disabled");
        }
    };

    first.addListener(SWT.KeyUp, listener);
    second.addListener(SWT.KeyUp, listener);

    shell.pack();
    shell.setSize(300, shell.getSize().y);
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}

private static boolean isEmpty(String input)
{
    if(input == null)
        return true;
    else
        return input.trim().isEmpty();
}
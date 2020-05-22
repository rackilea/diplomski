public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(1, false));

    Group first = new Group(shell, SWT.NONE);
    first.setText("RowLayout");
    first.setLayout(new RowLayout(SWT.HORIZONTAL));

    Group second = new Group(shell, SWT.NONE);
    second.setText("GridLayout");
    second.setLayout(new GridLayout(5, false));

    for (int i = 1; i < 5; i++)
    {
        new Button(first, SWT.PUSH).setText("Button " + i);
        new Button(second, SWT.PUSH).setText("Button " + i);
    }

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}
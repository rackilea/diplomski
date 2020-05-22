public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(1, false));

    Group group = new Group(shell, SWT.NONE);
    group.setText("Group");
    group.setLayout(new GridLayout(1, false));

    Composite composite = new Composite(group, SWT.NONE);
    composite.setLayout(new GridLayout(2, true));

    new Label(composite, SWT.NONE).setText("left");
    new Label(composite, SWT.NONE).setText("right");

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
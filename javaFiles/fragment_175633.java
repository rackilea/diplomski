public static void main(String args[])
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(2, false));

    Composite radioLeft = new Composite(shell, SWT.BORDER);
    radioLeft.setLayout(new GridLayout(6, false));
    radioLeft.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    for (int i = 0; i < 12; i++)
    {
        Button button = new Button(radioLeft, SWT.RADIO);
        button.setText("Radio " + i);
        button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    }

    Composite radioRight = new Composite(shell, SWT.BORDER);
    radioRight.setLayout(new GridLayout(4, false));
    radioRight.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    for (int i = 0; i < 8; i++)
    {
        Button button = new Button(radioRight, SWT.RADIO);
        button.setText("Radio " + i);
        button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    }

    Group groupLeft = new Group(shell, SWT.NONE);
    groupLeft.setLayout(new GridLayout(6, false));
    groupLeft.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    for (int i = 0; i < 12; i++)
    {
        Label label = new Label(groupLeft, SWT.NONE);
        label.setText("Something " + i);
        label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    }

    Group groupRight = new Group(shell, SWT.NONE);
    groupRight.setLayout(new GridLayout(1, false));
    groupRight.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

    for (int i = 0; i < 2; i++)
    {
        Label label = new Label(groupRight, SWT.NONE);
        label.setText("Something " + i);
        label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    }
    Group bottom = new Group(shell, SWT.NONE);
    bottom.setLayout(new GridLayout(6, false));
    bottom.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    for (int i = 0; i < 12; i++)
    {
        Label label = new Label(bottom, SWT.NONE);
        label.setText("Something " + i);
        label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    }

    Composite buttonComp = new Composite(shell, SWT.NONE);
    buttonComp.setLayout(new GridLayout(2, true));
    buttonComp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    Button left = new Button(buttonComp, SWT.PUSH);
    left.setText("Left");
    left.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    Button right = new Button(buttonComp, SWT.PUSH);
    right.setText("Right");
    right.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!shell.getDisplay().readAndDispatch())
            shell.getDisplay().sleep();
    }
}
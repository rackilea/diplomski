public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));

    Composite first = new Composite(shell, SWT.NONE);
    Composite second = new Composite(shell, SWT.NONE);

    GridLayout firstLayout = new GridLayout(1, false);
    first.setLayout(firstLayout);

    GridLayout secondLayout = new GridLayout(1, false);
    secondLayout.marginHeight = 0;
    secondLayout.marginWidth = 0;
    second.setLayout(secondLayout);

    Button firstButton = new Button(first, SWT.PUSH);
    firstButton.setText("Margin");
    Button secondButton = new Button(second, SWT.PUSH);
    secondButton.setText("No Margin");

    first.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    second.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    firstButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    secondButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    shell.pack();
    shell.open();

    while (!shell.isDisposed()) {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }

    display.dispose();
}
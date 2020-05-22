public static void main(String[] args)
{
    RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
    rowLayout.wrap = true;

    Display display = new Display();

    Shell shell = new Shell(display, SWT.RESIZE);
    shell.setLayout(new FillLayout());
    shell.setMinimumSize(1, 1);
    // shell.setLayout(rowLayout);

    Composite composite = new Composite(shell, SWT.NONE);
    composite.setLayout(rowLayout);

    Label label;
    for (int i = 0; i < 100; ++i)
    {
        // label = new Label(shell, SWT.NONE);
        label = new Label(composite, SWT.NONE);
        label.setText("A");
    }

    shell.pack();
    shell.open();
    shell.setSize(50, 200);
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
}
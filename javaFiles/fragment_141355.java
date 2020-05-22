public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");

    GridLayout layout = new GridLayout(3, false);
    layout.horizontalSpacing = 0;
    shell.setLayout(layout);

    for(int i = 0; i < 9; i++)
        new Label(shell, SWT.NONE).setText("Label: " + i);

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}
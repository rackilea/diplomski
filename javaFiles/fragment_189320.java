public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new RowLayout(SWT.VERTICAL));
    shell.setText("StackOverflow");

    for(int i = 0; i < 10; i++)
    {
        new Label(shell, SWT.NONE).setText("Label " + i);
    }

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
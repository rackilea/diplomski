public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    Text text = new Text(shell, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
    text.setText("fdfsdfsd");
    text.setEditable(false);
    text.setEnabled(false);
    text.setCursor(Display.getCurrent().getSystemCursor(SWT.CURSOR_ARROW));

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
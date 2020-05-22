public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Choose");
    button.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            FileDialog dialog = new FileDialog(shell);
            dialog.setFilterExtensions(new String[] { "abc.exe;xyz.exe" });

            System.out.println(dialog.open());
        }
    });

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
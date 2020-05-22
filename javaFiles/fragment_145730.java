public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(1, false));

    // Create a read-only text field
    final Text text = new Text(shell, SWT.BORDER);
    text.setEditable(false);
    text.setText("Some text here");

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Change");
    button.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            text.setEditable(!text.getEditable());
        }
    });

    shell.open();
    shell.pack();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }
    display.dispose();
}
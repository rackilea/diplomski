public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout(SWT.VERTICAL));
    shell.setText("StackOverflow");

    final Text text = new Text(shell, SWT.BORDER);

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Replace");
    button.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            String content = text.getText();
            Point selection = text.getSelection();

            /* Get the first non-selected part, add "Ball" and get the second non-selected part */
            content = content.substring(0, selection.x) + "Ball" + content.substring(selection.y, content.length());

            text.setText(content);
        }
    });

    shell.pack();
    shell.setSize(400,shell.getSize().y);
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}
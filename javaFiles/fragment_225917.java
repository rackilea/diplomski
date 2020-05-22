private static int lineNr = 0;

public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));

    final StyledText text = new StyledText(shell, SWT.BORDER);
    text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Add new line");
    button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    button.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            /* Get the start position of the new text */
            int start = text.getText().length();

            /* Create the new line */
            String newText = "Line: " + lineNr++ + "\n";

            /* Add it */
            text.append(newText);

            /* Determine the end of the new text */
            int end = start + newText.length();

            /* Set the selection */
            text.setSelection(start, end);
        }
    });

    shell.pack();
    shell.setSize(600, 400);
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}
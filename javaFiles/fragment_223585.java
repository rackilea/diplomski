public static void main(String[] args)
{
    Display d = new Display();
    final Shell shell = new Shell(d);
    shell.setLayout(new GridLayout(1, false));

    Text text = new Text(shell, SWT.BORDER);

    text.setText("Some random text here...");

    text.setSelection(text.getText().length());


    shell.pack();
    shell.open();
    while (!shell.isDisposed())
        while (!d.readAndDispatch())
            d.sleep();
}
public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(2, true));

    final Button button = new Button(shell, SWT.PUSH);
    button.setText("Focus catcher");

    final Table table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
    table.setHeaderVisible(true);

    for (int col = 0; col < 3; col++)
        new TableColumn(table, SWT.NONE).setText("Col " + col);

    for (int i = 0; i < 10; i++)
    {
        TableItem item = new TableItem(table, SWT.NONE);

        for (int col = 0; col < table.getColumnCount(); col++)
            item.setText(col, "Cell " + i + " " + col);
    }

    for (int col = 0; col < table.getColumnCount(); col++)
        table.getColumn(col).pack();

    table.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            table.deselectAll();

            button.setFocus();
            button.forceFocus();
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
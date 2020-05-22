public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(1, false));

    final Table table = new Table(shell, SWT.V_SCROLL | SWT.H_SCROLL);
    table.setHeaderVisible(true);

    final GridData data = new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false);
    data.widthHint = 200;
    data.heightHint = 200;
    table.setLayoutData(data);

    for(int i = 0; i < 5; i++)
    {
        TableColumn col = new TableColumn(table, SWT.NONE);
        col.setText("C" + i);
        col.pack();
    }

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Fill table");
    button.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            for(int i = 0; i < 100; i++)
            {
                TableItem item = new TableItem(table, SWT.NONE);

                for(int j = 0; j < table.getColumnCount(); j++)
                {
                    item.setText(j, "Item " + i + "," + j);
                }
            }

            for(int j = 0; j < table.getColumnCount(); j++)
            {
                table.getColumn(j).pack();
            }
        }
    });

    shell.pack();
    shell.setSize(400, 300);
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
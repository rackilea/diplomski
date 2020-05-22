public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("Stackoverflow");
    shell.setLayout(new RowLayout(SWT.VERTICAL));

    Table table = new Table(shell, SWT.BORDER);
    table.setHeaderVisible(true);

    for(int col = 0; col < 3;  col++)
    {
        TableColumn column = new TableColumn(table, SWT.NONE);
        column.setText("Col: " + col);
    }

    for(int row = 0; row < 20; row++)
    {
        TableItem item = new TableItem(table, SWT.NONE);

        for(int col = 0; col < table.getColumnCount();  col++)
        {
            item.setText(col, row + " " + col);
        }
    }

    for(int col = 0; col < table.getColumnCount();  col++)
    {
        table.getColumn(col).pack();
    }

    table.addListener(SWT.MouseDown, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            Table table = (Table) e.widget;

            System.out.println("Column: " + getColumn(table, e.x));
        }
    });

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}

private static int getColumn(Table table, int x)
{
    int overallWidth = 0;

    for(int i = 0; i < table.getColumnCount(); i++)
    {
        overallWidth += table.getColumn(i).getWidth();
        if(x < overallWidth)
        {
            return i;
        }
    }

    return -1;
}
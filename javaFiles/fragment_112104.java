private static int page = 0;
private static int pageSize = 10;

public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    final Table table = new Table(shell, SWT.NONE);
    table.addListener(SWT.MouseWheel, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            if(e.count < 0)
                addItems(table, page++);
            else if(e.count > 0)
                addItems(table, page--);
        }
    });

    addItems(table, page);

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}

private static void addItems(Table table, int topIndex)
{
    table.removeAll();
    for(int i = 0; i < pageSize; i++)
    {
        TableItem item = new TableItem(table, SWT.NONE);
        item.setText("Item: " + (i + (topIndex * pageSize)));
    }
}
public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    ScrolledComposite scrolledComposite = new ScrolledComposite(shell, SWT.V_SCROLL | SWT.H_SCROLL);
    scrolledComposite.setLayout(new FillLayout());

    Composite content = new Composite(scrolledComposite, SWT.NONE);
    content.setLayout(new GridLayout(3, true));

    for(int i = 0; i < 3; i++)
    {
        Table table = new Table(content, SWT.BORDER);
        table.setHeaderVisible(true);
        table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        for(int col = 0; col < 3; col++)
        {
            TableColumn column = new TableColumn(table, SWT.NONE);
            column.setText("Col " + col);
        }

        for(int row = 0; row < 10; row++)
        {
            TableItem item = new TableItem(table, SWT.NONE);

            for(int col = 0; col < table.getColumnCount(); col++)
            {
                item.setText(col, "Item " + row + " " + col);
            }
        }

        for(int col = 0; col < table.getColumnCount(); col++)
        {
            table.getColumn(col).pack();
        }


    }

    scrolledComposite.setContent(content);
    scrolledComposite.setExpandHorizontal(true);
    scrolledComposite.setExpandVertical(true);
    scrolledComposite.setMinSize(content.computeSize(SWT.DEFAULT, SWT.DEFAULT));

    shell.pack();
    shell.setSize(400,300);
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}
public MyDialog(Shell parentShell)
{
    super(parentShell);
}

@Override
protected Control createDialogArea(Composite parent)
{
    Composite container = (Composite) super.createDialogArea(parent);
    container.setLayout(new GridLayout(1, false));

    createTable(container);
    createTable(container);

    return container;
}

private void createTable(Composite parent)
{
    Table table = new Table(parent, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
    table.setHeaderVisible(true);

    TableColumn column = new TableColumn(table, SWT.NONE);
    column.setText("Column");

    for (int i = 0; i < 500; i++)
    {
        new TableItem(table, SWT.NONE).setText("Item " + i);
    }

    column.pack();

    table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
}

@Override
protected boolean isResizable()
{
    return true;
}

@Override
protected void configureShell(Shell newShell)
{
    super.configureShell(newShell);
    newShell.setText("StackOverflow");
}

@Override
protected Point getInitialSize()
{
    return new Point(450, 300);
}

public static void main(String[] args)
{
    new MyDialog(new Shell()).open();
}
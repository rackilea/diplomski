public static void main(String[] args)
{
    final Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(1, false));

    SashForm form = new SashForm(shell, SWT.VERTICAL);
    form.setLayout(new GridLayout(1, false));
    form.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    Composite top = new Composite(form, SWT.NONE);
    GridLayout layout = new GridLayout(2, false);
    layout.marginHeight = layout.marginWidth = 0;
    top.setLayout(layout);
    top.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    TableViewer first = createTableViewer(top);
    first.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    TableViewer second = createTableViewer(top);
    second.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    TableViewer third = createTableViewer(form);
    third.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    shell.pack();
    shell.setSize(shell.getSize().x, 400);
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

private static TableViewer createTableViewer(Composite parent)
{
    TableViewer viewer = new TableViewer(parent, SWT.MULTI | SWT.FULL_SELECTION | SWT.BORDER);

    createColumns(viewer);

    Table table = viewer.getTable();
    table.setHeaderVisible(true);
    table.setLinesVisible(true);

    List<String> data = new ArrayList<>();

    for (int i = 0; i < 20; i++)
        data.add("Item " + i);

    viewer.setContentProvider(ArrayContentProvider.getInstance());
    viewer.setInput(data);

    return viewer;
}

private static void createColumns(TableViewer viewer)
{
    TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
    column.getColumn().setWidth(200);
    column.getColumn().setText("Column");
    column.setLabelProvider(new ColumnLabelProvider()
    {
        @Override
        public void update(ViewerCell cell)
        {
            Object element = cell.getElement();
            if (element instanceof String)
            {
                String obj = (String) element;
                cell.setText(obj);
            }
        }
    });
}
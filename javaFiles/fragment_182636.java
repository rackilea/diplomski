public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    TableViewer viewer = new TableViewer(shell);

    /* Create the columns */
    for (int i = 0; i < 4; i++)
    {
        TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
        /* Set the trim label provider (will trim the text displayed) */
        column.setLabelProvider(new TrimLabelProvider());
        column.getColumn().setText("Column " + i);
    }

    /* Set the input from the content provider */
    viewer.setContentProvider(new ArrayContentProvider());
    viewer.setInput(DataModelProvider.getInstance().getItems());

    /* Style the table */
    Table table = viewer.getTable();
    table.setHeaderVisible(true);
    table.setLinesVisible(true);

    /* Pack the columns */
    for (TableColumn column : table.getColumns())
        column.pack();

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

/**
 * This class holds the data displayed in the table viewer
 */
private static class DataModelProvider
{
    private static DataModelProvider    INSTANCE;
    private List<TableRow>              items;

    public static DataModelProvider getInstance()
    {
        if (INSTANCE == null)
            INSTANCE = new DataModelProvider();

        return INSTANCE;
    }

    private DataModelProvider()
    {
        /*
         * Create dummy content. One item with short text and one item with
         * long text
         */
        items = new ArrayList<TableRow>();
        items.add(new TableRow(new String[] { "first", "second", "third", "fourth" }));
        items.add(new TableRow(new String[] { "first", "second second second second second second second second", "third", "fourth" }));
    }

    public void addItem(TableRow item)
    {
        items.add(item);
    }

    public List<TableRow> getItems()
    {
        return items;
    }
}

/**
 * This class models the data items displayed in the table
 */
private static class TableRow
{
    private String[]    data;

    public TableRow(String[] input)
    {
        data = input;
    }

    public String getData(int index)
    {
        if (index < 0 || index > data.length - 1)
            throw new IllegalArgumentException("Invalid index: " + index + ". Minimum: 0, Maximum: " + (data.length - 1));
        return data[index];
    }
}

/**
 * This class takes care of how the data is displayed in the table
 */
private static class TrimLabelProvider extends CellLabelProvider
{

    @Override
    public void update(ViewerCell cell)
    {
        /*
         * This method is called by the TableViewer to get
         * the String to display in the cell
         */
        Object element = cell.getElement();
        if (element instanceof TableRow)
        {
            int columnIndex = cell.getColumnIndex();

            TableRow row = (TableRow) cell.getElement();

            /* Here we trim the text */
            cell.setText(shortenText(row.getData(columnIndex)));
        }
    }

    private String shortenText(String text)
    {
        /* This is the maximal length we allow */
        int value = 20;

        if (text.length() > value)
        {
            int index = text.indexOf(" ", value);
            if (index != -1)
                return text.substring(0, index) + " [...]";
        }
        return text;
    }
}
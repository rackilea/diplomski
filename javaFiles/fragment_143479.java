JTable table = new JTable( ... );
table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );

for (int column = 0; column < table.getColumnCount(); column++)
{
    TableColumn tableColumn = table.getColumnModel().getColumn(column);
    int preferredWidth = tableColumn.getMinWidth();
    int maxWidth = tableColumn.getMaxWidth();

    for (int row = 0; row < table.getRowCount(); row++)
    {
        TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
        Component c = table.prepareRenderer(cellRenderer, row, column);
        int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
        preferredWidth = Math.max(preferredWidth, width);

        //  We've exceeded the maximum width, no need to check other rows

        if (preferredWidth >= maxWidth)
        {
            preferredWidth = maxWidth;
            break;
        }
    }

    tableColumn.setPreferredWidth( preferredWidth );
}
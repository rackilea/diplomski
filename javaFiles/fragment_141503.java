private static void addColumn( final JTable table, final String newColumnHeader )
{
    final JTableHeader header = table.getTableHeader();
    final int columnCount = header.getColumnModel().getColumnCount();
    boolean addColumn = true;
    for( int index = 0; index < columnCount; index ++ )
    {
        final Object headerValue = header.getColumnModel().getColumn(index).getHeaderValue();
        if( newColumnHeader.equals( headerValue ) )
        {
            JOptionPane.showMessageDialog(null, "Column already exists" );
            addColumn = false;
            break;
        }
    }

    if( addColumn )
    {
        final TableColumn newCol = new TableColumn();
        newCol.setHeaderValue(newColumnHeader);
        table.getColumnModel().addColumn(newCol);
    }

}
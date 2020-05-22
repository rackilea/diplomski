@Override
public void doLayout()
{
    if (tableHeader != null)
    {
        TableColumn resizingColumn = tableHeader.getResizingColumn();
        //  Viewport size changed. Increase last columns width

        if (resizingColumn == null)
        {
            TableColumnModel tcm = getColumnModel();
            int lastColumn = tcm.getColumnCount() - 1;
            tableHeader.setResizingColumn( tcm.getColumn( lastColumn ) ) ;
        }
    }

    super.doLayout();
}
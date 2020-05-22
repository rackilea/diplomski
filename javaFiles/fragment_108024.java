private class TableColumnWidthListener implements TableColumnModelListener
{
    @Override
    public void columnMarginChanged(ChangeEvent e)
    {
        /* columnMarginChanged is called continuously as the column width is changed
           by dragging. Therefore, execute code below ONLY if we are not already
           aware of the column width having changed */
        if(!tableObj.hasColumnWidthChanged())
        {
            /* the condition  below will NOT be true if
               the column width is being changed by code. */
            if(tableObj.getTableHeader.getResizingColumn() != null)
            {
                // User must have dragged column and changed width
                tableObj.setColumnWidthChanged(true);
            }
        }
    }

    @Override
    public void columnMoved(TableColumnModelEvent e) { }

    @Override
    public void columnAdded(TableColumnModelEvent e) { }

    @Override
    public void columnRemoved(TableColumnModelEvent e) { }

    @Override
    public void columnSelectionChanged(ListSelectionEvent e) { }
}
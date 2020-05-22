table.getSelectionModel().addListSelectionListener(new ListSelectionListener()
{
    int lastRow = -1;

    public void valueChanged(ListSelectionEvent e)
    {
        if (!e.getValueIsAdjusting())
        {
            if (lastRow != -1)
                table.setRowHeight(lastRow, table.getRowHeight());

            int row =  table.getSelectedRow();
            table.setRowHeight(row, 40);
            lastRow = row;
        }
    }
});
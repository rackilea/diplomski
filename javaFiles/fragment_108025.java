private class TableHeaderMouseListener extends MouseAdapter
{
    @Override
    public void mouseReleased(MouseEvent e)
    {
        /* On mouse release, check if column width has changed */
        if(tableObj.getColumnWidthChanged())
        {
            // Do whatever you need to do here

            // Reset the flag on the table.
            tableObj.setColumnWidthChanged(false);
        }
    }
}
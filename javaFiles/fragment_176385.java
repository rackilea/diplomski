public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
{
    Component c = super.prepareRenderer(renderer, row, column);

    //  Color row based on a cell value

    if (!isRowSelected(row))
    {
        //c.setBackground(getBackground()); //removed
        c.setBackground(row % 2 == 0 ? getBackground() : Color.LIGHT_GRAY); // added
        int modelRow = convertRowIndexToModel(row);
        String type = (String)getModel().getValueAt(modelRow, 0);

        if ("Buy".equals(type)) c.setBackground(Color.GREEN);
        if ("Sell".equals(type)) c.setBackground(Color.YELLOW);
    }

    return c;
}
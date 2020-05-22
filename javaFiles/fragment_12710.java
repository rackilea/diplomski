int modelColumn = convertColumnIndexToModel( column );

if (modelColumn == 1)
{
    String file = getModel.getValueAt(row, 0);

    if (file.endsWith(".txt"))
        return txtEditor;
    else if (file.endsWith(".html"))
        return htmlEditor;
}

return super.getCellEditor(row, column);
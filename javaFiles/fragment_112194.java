for(int i = 0; i < items.size(); i++)
{
    TableItem item = new TableItem(table, SWT.NONE);

    for(int j = 0; j < table.getColumnCount(); j++)
    {
        item.setText(j, "something here");
    }
}
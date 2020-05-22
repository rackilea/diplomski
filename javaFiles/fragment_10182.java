CustomRenderer colouringTable = new CustomRenderer();
int RowIndex = 0;
int i = 0;
for (String word : myDictionaryOne.keySet())
{
    if (myArrayOne.contains(word) == true)
    {
        tableModel.addRow(new Object[] { word });
        colouringTable.setColors(Color.GREEN);                           
        RowIndex++;
        i++;
    }
    if (i >= 10)
    {
        break;
    }
} 

int i = 0;
for (String word : myDictionaryTwo.keySet())
{
    if (myArrayTwo.contains(word) == true)
    {
        tableModel.addRow(new Object[] { word });
        colouringTable.setColors(Color.RED);                         
        RowIndex++;
        i++;
    }
    if (i >= 10)
    {
        break;
    }
} 
desiredJTable.getColumnModel().getColumn(0).setCellRenderer(colouringTable);
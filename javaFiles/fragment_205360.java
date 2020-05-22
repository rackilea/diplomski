private <T extends MyClassInterface> InputElement getInputElement(int rowIndex, int columnIndex, CellTable<T> cellTable)                    
{             
    InputElement input = null;              
    if (isColumnEditable(columnIndex))  
    {  
        input = (InputElement)  cellTable.getRowElement(rowIndex).getCells().getItem(columnIndex).getFirstChild().getFirstChild();  
    }  
    return input;
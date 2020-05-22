@Override
    public void setValueAt( Object inValue, int inRow, int inCol ) {
        ProductRow productRow = (ProductRow)( getRowsData().get(inRow) );

        //more code 
        productRow.setCantidad( inValue.toString() ); // when this is called all properties of productRow are changed.                 

        //fireTableCellUpdated( inRow, inCol );// this don't refresh cause i change the row also
        //fireTableDataChanged(); - First approach. As pointed out this is wrong because it refreshes all table cells
        fireTableRowsUpdated(inRow,inRow); // adding this
    }
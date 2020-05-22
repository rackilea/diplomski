if(p==JOptionPane.YES_OPTION)
{
    int row = mtt.getSelectedRows()[0];// returns row position(Here mtt is  name of table)
    model.removeRow(row);  
    for(int index=row ;index<model.getRowCount();index++){
        model.setValueAt(index+1, index, 0); //setValueAt(data,row,column)
    }
}
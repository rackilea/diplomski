TableModel model = jTable1.getModel();
for(int i = 0; i < model.getColumnCount(); i++){
    if(i > 0){
        System.out.println(", ");
    }
    System.out.println(model.getValueAt(selectedRowIndex, selectedColumnIndex));
}
System.out.println();
public void getSum(){
    int rowcount1 = JV_tbl.getRowCount();
    DefaultTableModel tbm1 = (DefaultTableModel) JV_tbl.getModel();
    for(int i = rowcount1-1; i >=0; i--){
        if(JV_tbl.getValueAt(i, 6) == null){
            tbm1.removeRow(i);
        }       
    }

    int total=0;
    for(int i=0; i<JV_tbl.getRowCount(); i++){
        int amount = Integer.parseInt(JV_tbl.getValueAt(i, 6).toString());

        total+=amount;
    }
    JV_totalDebit_box.setText(String.valueOf(total));

}
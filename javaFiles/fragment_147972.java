class MyTableCellRenderer extends DefaultTableCellRenderer implements TableCellRenderer {
 AssignOrderToWax ass =null;

 public MyTableCellRenderer( AssignOrderToWax ass){
     this.ass=ass;
 }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setForeground(Color.BLACK);
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


        Object orderId="";
        Object design="";
         Object sno="";
        for(int r=0;r<ass.tblDetailInfo.getRowCount();r++){
         orderId=ass.tblDetailInfo.getValueAt(r, ass.util.getColumnIndex(ass.tblDetailInfo, "orderId"));
         design=ass.tblDetailInfo.getValueAt(r, ass.util.getColumnIndex(ass.tblDetailInfo, "design"));
         sno=ass.tblDetailInfo.getValueAt(r, ass.util.getColumnIndex(ass.tblDetailInfo, "sno"));

if((ass.tblOrderInfo.getValueAt(row, ass.util.getColumnIndex(ass.tblOrderInfo, "orderId")).equals(orderId))
     && (ass.tblOrderInfo.getValueAt(row, ass.util.getColumnIndex(ass.tblOrderInfo, "design")).equals(design))
     && (ass.tblOrderInfo.getValueAt(row, ass.util.getColumnIndex(ass.tblOrderInfo, "sno")).equals(sno))

        ){ 
            setForeground(Color.RED);
            break ;

            }

    }return this;
    }

}
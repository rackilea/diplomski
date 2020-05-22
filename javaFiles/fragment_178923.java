// You will need to fill this out with appropriate values,
// the number of columns in you JTable should match the
// the number columns from your query...
Object[] columns = new Object[]{....};
model = new DefaultTableModel(columns, 0);
while(rs.next()){
    Object[] objects = new Object[colNo];
    for(int i=0;i<colNo;i++){
        objects[i]=rs.getObject(i+1);
    }
    model.addRow(objects);
}
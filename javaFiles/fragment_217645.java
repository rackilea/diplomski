private void sendMouseClicked(java.awt.event.MouseEvent evt) {                                    
    String sn=en.getText();
    int n=Integer.valueOf(sn);
    java.util.Vector columns = new java.util.Vector();
    columns.add("Your Column Name");
    java.util.Vector rows = new java.util.Vector();
    for(int j=2;j<=n;j++){
        java.util.Vector row = new java.util.Vector();
        row.add(test.getText()+j);
        rows.add(row);
        test.setText(test.getText()+j);
    }
    DefaultTableModel model = new DefaultTableModel(rows, columns);
    tab.setModel(model);
}
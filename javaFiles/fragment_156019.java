DefaultTableModel dd = (DefaultTableModel) jtable1.getModel();
dd.setRowCount(0);
while (rs1.next()) {                    
    txtInvoiceID.setText((rs1.getString("inid")));
    Vector v = new Vector();
    v.add(rs1.getInt("itid"));
    v.add(rs1.getString("itname"));
    v.add(rs1.getInt("qty"));
    v.add(rs1.getDouble("sprice"));
    v.add(rs1.getDouble("total"));
    dd.addRow(v);
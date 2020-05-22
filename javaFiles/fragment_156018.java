DefaultTableModel dd = new DefaultTableModel();
// Set the columns for the table model...
jtable1.setModel(dd);
while (rs1.next()) {                    
    txtInvoiceID.setText((rs1.getString("inid")));
    Vector v = new Vector();
    v.add(rs1.getInt("itid"));
    v.add(rs1.getString("itname"));
    v.add(rs1.getInt("qty"));
    v.add(rs1.getDouble("sprice"));
    v.add(rs1.getDouble("total"));
    dd.addRow(v);
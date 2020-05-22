private void addToInvoiceLine(){
    try {
        String sql = "INSERT INTO invoiceLine (invoiceID,SKU,quantity) VALUES (?,?,?)";
        pst = conn.prepareStatement(sql); 


        for(int row=0; row<orderTable.getModel().getRowCount(); row++){
            String sku = orderTable.getModel().getValueAt(row, 0).toString();
            String quantity = orderTable.getModel().getValueAt(row, 2).toString();

            pst.setString(1, invoiceNo.getText());
            pst.setString(2, sku);
            pst.setString(3, quantity);

            pst.execute();
        }


    } catch (SQLException | HeadlessException e) {
        JOptionPane.showMessageDialog(null, e);
    } finally {
        try {
            rs.close();
            pst.close();
        } catch (Exception e) {
        }
    }

}
private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    try{
        String url = "jdbc:odbc:mydata";
        Connection conn = DriverManager.getConnection(url,"","");
        String value1=tfSupName1.getText();
        String value2=tfType1.getText();
        String value3=tfStock1.getText();
        String sql="UPDATE User set SupplierName='"+value1+"' ,MarbleType='"+value2+"' ,InStock='"+value3+"' Where Supplier_id=1";
        pst=conn.prepareStatement(sql);
        pst.execute();
    }
    catch(Exception e){JOptionPane.showMessageDialog(null,e);}

    }
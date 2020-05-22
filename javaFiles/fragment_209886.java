private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {                                         
    try{
        String selected=(String)jComboBoxSelected.getSelectedItem();
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ "employee_certificate","root","");

          String sql="SELECT stuff.Emp_Id,stuff.Emp_Name, stuff.Department, "
            + "certificate.Cert_Code, certificate.Cert_Name,\n" +
            "certificate.Cert, certificate.Vendor, certificate.Date_Taken, "
            + "certificate.Expiry_Date FROM stuff LEFT JOIN certificate"
              + " ON stuff.Emp_Id=certificate.Emp_Id  "
               +"WHERE "+selected+" LIKE ? ORDER BY stuff.Emp_Name\n" ; 
       PreparedStatement  pstmt=con.prepareStatement(sql);
       pstmt.setString(1,jTextFieldSearch.getText() + "%");
       ResultSet rs=pstmt.executeQuery();
       jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        pstmt.close();
        con.close();
    }
    catch(Exception ex){ex.printStackTrace();} 
}
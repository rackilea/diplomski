pst=(PreparedStatement) conn.prepareStatement(sql);            
    pst.setString (1, txt_isbn.getText());          
    int deleted = pst.executeUpdate();               

    if (deleted == 0) {
    ...
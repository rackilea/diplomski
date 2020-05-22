try{ 
Statement s = DB2.kavish().createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM Invoice WHERE Invoice_No='"+jTextField28.getText()+"'");

        while (rs.next()){

        jTextField29.setText(rs.getString(2));
        jTextField30.setText(rs.getString(3));
        jTextField31.setText(rs.getString(4));
        jTextField32.setText(rs.getString(5));
        jTextField33.setText(rs.getString(6));
        jTextField34.setText(rs.getString(7));
        jTextField35.setText(rs.getString(8));
        jDateChooser1.setDate(rs.getDate(9));

}
    } catch (Exception e) {
    e.printStackTrace();
    }
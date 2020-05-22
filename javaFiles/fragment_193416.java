private void loadAllStudent(java.awt.event.ActionEvent evt) {                                        
    try{
        String url = "jdbc:derby://localhost:1527/mim";
        String username = "is2560";
        String password = "is2560";
        Connection conn = DriverManager.getConnection(url,username,password);
        Statement stmt = conn.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_READ_ONLY);
        String query = "SELECT * from students";
        rs = stmt.executeQuery(query);           
        while (rs.next()){
            Student lStudent = new Student();
      lStudent.setId(rs.getInt("ID"));
      lStudent.setFirstname(rs.getString("FNAME"));
      lStudent.setLastName(rs.getString("LNAME"));
      lStudent.setMName(rs.getString("MNAME"));
      lStudent.setInfo(rs.getString("STUDENTNO"));
      lStudent.setCourse(rs.getString("COURSE"));
      mAllStudent.add(lStudent);


        }
        else {
            rs.previous();
            JOptionPane.showMessageDialog(this, "End of File");
        }
    }
    catch (SQLException err){
        JOptionPane.showMessageDialog(this, err.getMessage());
    }
}
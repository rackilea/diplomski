try{
    String url = "jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false";
    String uname = "root";
    String pass = "password";
    String query = "insert into emp values (";
    Connection con = DriverManager.getConnection(url,uname,pass);
    Statement st = con.createStatement();

    query += idTextField.getText() + "," + fNameTextField.getText() + "," + lNameTextField.getText() + ")";
     st.executeUpdate(query);
    JOptionPane.showMessageDialog(null, "The data has been saved successfully!!", "Success", JOptionPane.INFORMATION_MESSAGE);

    } 

   catch (SQLException ex) {
        Logger.getLogger(AddFrame.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
    }
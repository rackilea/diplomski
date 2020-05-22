public void displayUsers(String f, String s) {
    try {
        String queryString = "SELECT * FROM staff where SName=? and SPwd=?";
        //set this values using PreparedStatement
        ResultSet results = ps.executeQuery(queryString); //where ps is Object of PreparedStatement

        if(!results.next()) {

              JOptionPane.showMessageDialog("Wrong Username and Password.");  
        }

    } catch (SQLException sql) {

        out.println(sql);
    }finally{
      //closing ResultSet,PreparedStatement and Connection object
    }
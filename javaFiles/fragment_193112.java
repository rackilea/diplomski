public void info(String userName){

    String sql = "SELECT name, surname, age, username FROM member WHERE username = ?";

    try (
            PreparedStatement stmt  = connection.prepareStatement(sql);
            stmt.setString(1, userName);
            ResultSet rs    = stmt.executeQuery(sql)){

        // loop through the result set
        while (rs.next()) {
            String fname = rs.getString("name");           
            String sname = rs.getString("surname"); 
            int age = rs.getInt("age");       
            String uname = rs.getString("username");

            lblFName.setText(fname);
            lblSName.setText(sname);
            lblAge.setText(String.valueOf(age));
            lblUName.setText(uname);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    }
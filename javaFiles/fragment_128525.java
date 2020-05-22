String email = email_register_txt.getText();
String username = username_register_txt.getText();

try {
    Connection conn = DriverManager.getConnection("...your jdbc connection string...");
    conn.setAutoCommit(false);

    String sql = "SELECT * FROM user_profile WHERE username = ? OR user_email = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, username);
    stmt.setString(2, email);

    ResultSet res = stmt.executeQuery();

    // Utilize a boolean Flag to indicate whether 
    // or not the User is registered.
    boolean registered = false; 
    while (res.next()) {
        if(res.getString("username").equalsIgnoreCase(username)) {
            JOptionPane.showMessageDialog(registerPanel, 
                    "The username has already been already registered!");
            registered = true;
            break; // Get out of the loop. No more need for it.
        }
        else if(res.getString("user_email").equalsIgnoreCase(email)) {
            JOptionPane.showMessageDialog(registerPanel, 
                    "This email address has already been already registered!");
            registered = true;
            break; // Get out of the loop. No more need for it.
        }
    }

    // Do what needs to be done if User is NOT registered.
    if (!registered) {
        ...............................
        ...............................
    }
    res.close();
    stmt.close();
    conn.close(); //Close the DB connection
}
catch (SQLException ex) {
    ex.printStackTrace();
}
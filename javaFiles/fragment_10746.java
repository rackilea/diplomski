public void search(String ID) throws SQLException {
    boolean sawOne = false;

    PreparedStatement mystate = con.prepareStatement(
        "SELECT * FROM users WHERE id LIKE ?"
    );
    mystate.setString(1, ID);
    ResultSet rs = mystate.executeQuery(mystate);    

    while (rs.next()) {
        sawOne = true;
        System.out.println("Your Name is " + rs.getString("name"));   
    }
    if (!sawOne) {
        System.out.println("...");
    }
}
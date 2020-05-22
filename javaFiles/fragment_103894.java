public boolean addNewUser(User user) {
    boolean success = false;

    int executedValue = 0;

    try {
        Connection conn = DBConnection.getConnection();

        String query = "INSERT INTO Users (id, firstName, lastName, email, address, phonenumber, dob) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, user.getId());
        stmt.setString(2, user.getFirstName());
    } catch (Exception e) {
        System.out.println(e);
    }

    return success;
}
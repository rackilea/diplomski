public User findUser(String phone) {
    // todo
    return null;
}

//  DDL: CREATE TABLE user (name VARCHAR(100), phone VARCHAR(100))
public boolean saveUser(User user) throws ServletException {
    try (
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "secret");
         PreparedStatement ps = con.prepareStatement("INSERT INTO user VALUES(?,?)"))
    {
        ps.setString(1, user.getName());
        ps.setString(2, user.getPhone());
        return ps.execute();
    } catch (SQLException e) {
        throw new ServletException("DB operation failed", e);
    }
}
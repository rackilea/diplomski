public int addAssembler(int assemblerID, String name, boolean active) throws DatabaseException {
    Connection con = connect();
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        String query = "INSERT INTO assemblers (name, hidden) VALUES ('" + name + "'," + active + ")";
        ps = con.prepareStatement(query);
        System.out.println("addAssembler " + ps.toString());
        ps.executeUpdate(query);
    } catch (SQLException e) {
        throw new DatabaseException(e); // <----- THIS IS IMPORTANT
    } finally {
        close(rs, ps, con);
    }
    return 1;
}
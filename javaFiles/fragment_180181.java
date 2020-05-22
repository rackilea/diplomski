private User getUserResultSet(int beamID) {
    User user = null;
    try (Connection conn = dataSource.getConnection()) {
        PreparedStatement stmt = conn.prepareStatement(queries.getUserByBeamID());

        stmt.setInt(1, beamID);

        ResultSet rs = stmt.executeQuery();
        rs.next();
        user = new User(this,
            rs.getInt("beamID"),
            rs.getString("name"),
            rs.getInt("points"),
            rs.getInt("time")
        );

    } catch (SQLException e) {
        e.printStackTrace();
        throw new IllegalStateException();
    }

    return user;
}
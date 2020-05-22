try (Connection conn = dataSource.getConnection()) {
    PreparedStatement stmt = conn.prepareStatement(queries.getUserByBeamID());

    stmt.setInt(1, beamID);
    System.out.println(stmt.toString());
    return stmt.executeQuery();
} catch (SQLException e) {
    e.printStackTrace();
    throw new IllegalStateException();
}
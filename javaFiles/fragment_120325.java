try {
        connection.setAutoCommit(true);
        String sql = "insert into testtable values(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, userId);
        statement.setString(2, userName);
        saveStatus  = statement.execute();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return saveStatus;
}
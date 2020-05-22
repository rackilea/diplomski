@Override
public boolean isEmpty(Connection connection) {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    boolean res = false; // no need for the wrapper type here.

    String sql = "SELECT COUNT(*) FROM Persons";
    try {
        statement = connection.prepareStatement(sql);

        System.out.println(sql);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            res = resultSet.getInt(1) > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return res;
}
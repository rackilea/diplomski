public boolean hasRank(Player player, EnumRanks rank) {
    if (!MySql.checkConnection()) {
        return false;
    }
    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet result = null;
    String query = "SELECT RANK FROM `user_ranks` WHERE UUID=? AND RANK=?";
    try {
        conn = MySql.getConnection();
        statement = conn.prepareStatement(query);
        statement.setString(1, player.getUniqueId());
        statement.setString(2, rank.getSQLName());
        result = statement.executeQuery();
        return result.next();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (result != null) {
            try {
                result.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    return false;
}
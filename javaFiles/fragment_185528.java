final String queryCheck = "SELECT count(*) from messages WHERE msgid = ?";
final PreparedStatement ps = conn.prepareStatement(queryCheck);
ps.setString(1, msgid);
final ResultSet resultSet = ps.executeQuery();
if(resultSet.next()) {
    final int count = resultSet.getInt(1);
}
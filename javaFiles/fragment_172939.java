Connection conn = /*connection provided elsewhere*/;
List<String> items = /*item values provided elsewhere*/;

StringBuilder sql = new StringBuilder();
sql.append("select distinct A.ID" +
            " from Products A" +
            " join Products B on B.ID = A.ID" +
           " where A.Item in (");
for (int i = 0; i < items.size(); i++) {
    if (i != 0) sql.append(',');
    sql.append('?');
}
sql.append(')');
try (PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
    for (int i = 1; i <= items.size(); i++)
        stmt.setString(i, items.get(i));
    try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            int id = rs.getInt("ID");
            // use id here
        }
    }
}
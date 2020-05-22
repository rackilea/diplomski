char[] markers = new char[list.size() * 2 - 1];
for (int i = 0; i < markers.length; i++)
    markers[i] = (i & 1 == 0 ? '?' : ',');
String sql = "select * from employee where id in (" + markers + ")";
try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    int idx = 1;
    for (String value : list)
        stmt.setString(idx++, value);
    try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            // code here
        }
    }
}
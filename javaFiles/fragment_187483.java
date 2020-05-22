ResultSet rs = ...
StringBuilder b = new StringBuilder();
while(rs.next()) {
 String s = rs.getString(1);
 int n1 = rs.getInt(2);
 int n2 = rs.getInt(3);
 b.append(s);
 b.append(",");
 b.append(n1);
 b.append(",");
 b.append(n2);
 b.append("|");
}
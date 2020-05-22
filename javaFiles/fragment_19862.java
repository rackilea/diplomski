// getting ids from User

List<Integer> cityIds = new ArrayList<Integer>();
String query = "select city_ID from user where name = ?";
PreparedStatement ps = con.prepareStatement(query);
ps.setString(1, name);
ResultSet rs = ps.executeQuery();
while (rs.next()) {
   cityIds.add(rs.getInt("city_ID"));
}

// dynamically create your query

StringBuilder builder = new StringBuilder("select * from city where ID in (");
for (int i = 0; i < cityIds.size(); i++) {
   builder.append("?");
   if (i < cityIds.size() - 1) {
      builder.append(",");
   }
}
builder.append(")");

// creating PreparedStatement

ps = con.prepareStatement(builder.toString());

// adding params to query

int index = 1;
for (Integer id: cityIds) {
   ps.setInt(index, id);
   index++;
}

ResultSet rs = ps.executeQuery();
while (rs.next()) {
   // do your stuff
}
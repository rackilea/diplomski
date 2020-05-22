// example data
int theId = 1;
String theName = "the name you received from somewhere else";
//
PreparedStatement ps = conn.prepareStatement("INSERT INTO sample (id, name) VALUES (?, ?)");
ps.setInt(1, theId);
ps.setString(2, theName);
ps.executeUpdate();
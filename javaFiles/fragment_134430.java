PreparedStatement ps = con.prepareStatement("CALL LINK_SCHEMA(?, '', ?, ?, ?, ?)");
ps.setString(1, "ROADS");
ps.setString(2, url);
ps.setString(3, user);
ps.setString(4, pass);
ps.setString(5, "ROADS");
ResultSet rs = ps.executeQuery();
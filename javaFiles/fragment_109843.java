String sql = "INSERT INTO meta (title, hlcount, textcount, imgcount, linkcount)"
             + " VALUES (?, ?, ?, ?, ?)";
PreparedStatement pst = conn.prepareStatement(sql);
pst.setString(1, "SomeString");
pst.setInt(2, 6);
// etc
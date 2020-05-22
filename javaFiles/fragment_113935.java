String SQL = "INSERT INTO Workers VALUES (?, ?, ?, ?)";
PreparedStatement pstmt = con.prepareStatement(SQL);
p.setInt(1, num);
p.setString(2, fName);
p.setString(3, lName);
p.setString(4, jTitle);
pstmt.executeUpdate();
pstmt.close();
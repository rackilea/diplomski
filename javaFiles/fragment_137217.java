String update = "UPDATE table SET project_key=? WHERE login=?";
PreparedStatement pstmt = conn.preparedStatement(update);
pstmt.setString(1, newKey);
pstmt.setString(2, userLogin);

int testForUpdate = pstmt.executeUpdate();

System.out.println(int>0?"Update was done":"No update occured");
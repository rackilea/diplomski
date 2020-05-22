String jsonData = "field28436": [....]";
PreparedStatement pstmt = connection.prepareStatement(
      "insert into my_table (id, data) values (?, ?)");
pstmt.setInt(1, 42);
pstmt.setString(2, jsonData);
pstmt.executeUpdate();
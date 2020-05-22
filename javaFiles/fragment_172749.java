String sql = "Select * from SomeTable where SomeColumn = ?";

PreparedStatement stmt = connection.prepareStatement(sql);
stmt.setString(1, someColumnVariable);

ResultSet rs = stmt.executeQuery();
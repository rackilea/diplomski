String insert = "INSERT INTO SizeTable2 (Value1,Value2) VALUES(?, ?)";

try (PreparedStatement insert = connection.prepareStatement(insert)) {
    insert.setString(1, width);
    insert.setString(2, height);
    insert.executeUpdate();
}
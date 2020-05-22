String dateText = "11/8/2015 1:35 PM";
Date dateTime = new SimpleDateFormat("M/d/yyyy h:mm a").parse(dateText);

String sql = "UPDATE MyTable SET MyDateTime = ? WHERE MyId = ?";
try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    stmt.setTimestamp(1, new Timestamp(dateTime.getTime()));
    stmt.setInt(2, 1234);
    stmt.executeUpdate();
}
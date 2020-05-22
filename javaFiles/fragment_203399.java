String sql =
    "INSERT INTO EC_TABLE" +
    "(licenseid, customername, description, servername,licensetype, username,password, createdDateTime,ExpiredDateTime)" +
    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
PreparedStatement stmt = connection.prepareStatement(sql);
stmt.setString(1, licenseId);
...
stmt.setTimestamp(9, timestampexpired);
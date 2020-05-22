// Create the connection (unchanged)
Properties connInfo = new Properties();
connInfo.put("user", "Main");
connInfo.put("password", "poiuyt");
Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost/ABCNews", connInfo);

// Prepare the statement - should only be done once, even if you are looping.
String sql = "insert into abcnews_topics VALUES (null, ?)";
PrepatedStatement stmt = connection.prepareStatement(sql);

// Bind varaibles
stmt.setString (1, text_topic); // Note that indexes are 1-based.

// Execute
stmt.executeUpdate();
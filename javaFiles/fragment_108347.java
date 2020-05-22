Connection con1 = DriverManager.getConnection("jdbc:derby://localhost:1527/mhjtestdatabase", null, null);
Connection con2 = DriverManager.getConnection("jdbc:derby://localhost:1527/mhjtestdatabase", null, null);
Connection con3 = DriverManager.getConnection("jdbc:derby://localhost:1527/mhjtestdatabase", null, null);
Statement stmt2 = con2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
Statement stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
Statement stmt3 = con3.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
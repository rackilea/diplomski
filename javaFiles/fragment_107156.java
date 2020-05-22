ResultSetMetaData rsmd = rs.getMetaData();
 int numberOfColumns =rsmd.getColumnCount();

 while (rs.next()) {
      for (byte i = 1; i <= numberOfColumns; i++) {
           result = result+" "+rs.getString(i);
      }
 }
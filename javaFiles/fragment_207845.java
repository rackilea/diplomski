while (rs.next()){
     java.util.ArrayList alRowData = new java.util.ArrayList();
     java.sql.ResultSetMetaData rsmd = rs.getMetaData();
     int numberOfColumns = rsmd.getColumnCount();
     for(int columnIndex = 1; columnIndex <= numberOfColumns; columnIndex ++){
          alRowData.add(rs.getObject(columnIndex));
     }
     System.out.println(alRowData);
}
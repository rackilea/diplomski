SqlRowSetMetaData sqlRowSetMetaData = result.getMetaData();

   String[] columnNames = sqlRowSetMetaData.getColumnNames();

   foreach(String columnName : columnNames){
        result.getXXX(columnName);
   }
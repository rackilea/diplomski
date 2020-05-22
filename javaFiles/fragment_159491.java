results = statement.executeQuery("SELECT * FROM " + database + ".dbo." + tablename);
  ResultSetMetaData metaData = results.getMetaData();

  if (metaData != null) {
        System.out.println(database + ".dbo." + tablename+"ColumnCount()"+metaData.getColumnCount());
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                columnMap.put(metaData.getColumnName(i), metaData.getColumnTypeName(i));
            }
        }
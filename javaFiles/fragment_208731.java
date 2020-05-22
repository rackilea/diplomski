try (ResultSet resultSet = pStatement.executeQuery()) {
    ResultSetMetaData meta = resultSet.getMetaData();
    int ncols = meta.getColumnCount();
    while (resultSet.next()) {
        JSONObject tObject = new JSONObject();
        for (int colno = 1; colno <= ncols; ++colno) {
            String label = meta.getColumnLabel(colno); // Key
            String name = meta.getColumnName(colno);
            String sqlType = meta.getColumnType();
            String type = meta.getColumnClassName();
            String thisKeyName = label;
            Object thisKeyValue = result.getObject(colno);
            if (sqlType.contains("CHAR")) {
                thisKeyVaule = result.getString(colno);
                tObject.put(nextKeyName, nextKeyValue);
            } else if (sqlType.contains("INT")) {
                thisKeyVaule = result.getInt(colno);
                tObject.put(nextKeyName, nextKeyValue);
            } else {
                tObject.put(nextKeyName, nextKeyValue);
            }
        }
        tContainer.put(tObject);
    }
}
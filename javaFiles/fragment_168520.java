while (resultSet.next()) { //Read every row
        int columnCount = resultSet.getMetaData().getColumnCount();
        for (int column = 1; column <= columnCount; column++) { //Read every column
            String columnName = resultSet.getMetaData().getColumnName(column);
            Object value = resultSet.getObject(columnName);
            if (value != null) {
                doSomething(columnName, value);
            }

        }         
    }
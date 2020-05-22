ResultSetMetaData rsmd = resultSet.getMetaData();
int columnCount = rsmd.getColumnCount();

while (resultSet.next()) {
    // you get a single result row in here, not the entire ResultSet
    for (int i = 1; i <= columnCount; i++) {
        int type = rsmd.getColumnType(i);
        String typeName = rsmd.getColumnTypeName(i);
        String name = rsmd.getColumnName(i);
        String value;
        switch (type) {
        case Types.VARCHAR:
            value = resultSet.getString(i) == null ? "null" : resultSet.getString(i);
            System.out.println(name + ": " + value);
            break;
        case Types.DOUBLE:
            value = resultSet.getString(i) == null ? "null" : String.valueOf(resultSet.getDouble(i));
            System.out.println(name + " [" + typeName + "]: " + value);
            break;
        case Types.INTEGER:
            value = resultSet.getString(i) == null ? "null" : String.valueOf(resultSet.getInt(i));
            System.out.println(name + " [" + typeName + "]: " + value);
            break;
        case Types.DATE:
            value = resultSet.getString(i) == null ? "null" : String.valueOf(resultSet.getDate(i).toString());
            System.out.println(name + " [" + typeName + "]: " + value);
            break;
        case Types.TIMESTAMP:
            value = resultSet.getString(i) == null ? "null" : resultSet.getTimestamp(i).toString();
            System.out.println(name + " [" + typeName + "]: " + value);
            break;
        case Types.BOOLEAN:
            value = resultSet.getString(i) == null ? "null" : (resultSet.getBoolean(i) ? "true" : "false");
            System.out.println(name + " [" + typeName + "]: " + value);
            break;
        case Types.DECIMAL:
        case Types.NUMERIC:
            value = resultSet.getString(i) == null ? "null" : resultSet.getBigDecimal(i).toString();
            System.out.println(name + " [" + typeName + "]: " + value);
            break;
        default:
            System.out.println("The column type (" + rsmd.getColumnTypeName(i)
                    + " for column " + rsmd.getColumnName(i) + ", Label: " + rsmd.getColumnLabel(i)
                    + ") is currently not supported in method \"printResultColumns\".\nAdd it as case there.");
        }

    }
}
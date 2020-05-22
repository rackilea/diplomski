public void copy(String table, Connection from, Connection to) throws SQLException {
    try (PreparedStatement s1 = from.prepareStatement("select * from " + table);
         ResultSet rs = s1.executeQuery()) {
        ResultSetMetaData meta = rs.getMetaData();

        List<String> columns = new ArrayList<>();
        for (int i = 1; i <= meta.getColumnCount(); i++)
            columns.add(meta.getColumnName(i));

        try (PreparedStatement s2 = to.prepareStatement(
                "INSERT INTO " + table + " ("
              + columns.stream().collect(Collectors.joining(", "))
              + ") VALUES ("
              + columns.stream().map(c -> "?").collect(Collectors.joining(", "))
              + ")"
        )) {

            while (rs.next()) {
                for (int i = 1; i <= meta.getColumnCount(); i++)
                    s2.setObject(i, rs.getObject(i));

                s2.addBatch();
            }

            s2.executeBatch();
        }
    }
}
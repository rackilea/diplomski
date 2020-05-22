public static int[] batchUpdate(Connection conn, String localIPAddress) throws SQLException {
        int[] changedRows = null;
        try (PreparedStatement batchUpdate = conn.prepareStatement("UPDATE table1 SET column1 = ? where id = ?")) {
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM table1");
                while (rs.next()) {
                    // id => something unique for this row within the table,
                    // typically the primary key
                    String id = rs.getString("id");

                    String jid = rs.getString("column1");
                    if("abc".equals(jid)) { // just some nonsense condition
                        batchUpdate.setString(1, localIPAddress);
                        batchUpdate.setString(2, id);
                        batchUpdate.addBatch();
                    }
                }
            }
            changedRows = batchUpdate.executeBatch();
        }
        return changedRows;
    }
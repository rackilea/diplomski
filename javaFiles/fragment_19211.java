public static int preparedUpdate(Connection conn, String localIPAddress) throws SQLException {
        int numChangedRows = 0;

            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM table1");
                while (rs.next()) {
                    // id => something unique for this row within the table,
                    // typically the primary key
                    String id = rs.getString("id");
                    String jid = rs.getString("column1");
                    if("abc".equals(jid)) { // just some nonsense condition
                        try (PreparedStatement batchUpdate = conn.prepareStatement("UPDATE table1 SET column1 = ? where id = ?")) {
                            batchUpdate.setString(1, localIPAddress);
                            batchUpdate.setString(2, id);
                            numChangedRows = batchUpdate.executeUpdate();
                        }
                    }
                }
        }
        return numChangedRows;
    }
try (PreparedStatement stm = conn.prepareStatement(
        "INSERT INTO moviesTbl  (title, ...) VALUES(?, ? ...)")) {
    stm.setString(1, title);
    stm.setString(2, ...);
    ...
    int updateCount = stm.executeUpdate();
    if (updateCount != 0) {
        try (ResultSet genKeys = stm.getGeneratedKeys()) {
            if (genKeys.next()) { // At most 1 record inserted
                // Normally only one key generated per record.
                int id = genKeys.getInt(0);
                ...
            }
        } // Close result set.
    }
} // Closes stm
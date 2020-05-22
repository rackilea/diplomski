String[] createTableStatements = allStatements.Split...
for (String createStatement : createTableStatements) {
    try (Statement ps = connection.createStatement()) {
        ps.executeUpdate(createStatement);
    }
}
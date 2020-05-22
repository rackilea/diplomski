try (Connection c = dbSetup.getConnection()) {
    try (PreparedStatement s = c.prepareStatement(
        "insert into \"T\" (\"ID\") values (?)", new String[] { "ID" })) {
        s.setInt(1, 1);
        s.execute ();
    }
}
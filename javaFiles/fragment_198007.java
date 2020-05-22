try (PreparedStatement insert = connection.prepareStatement(
        "insert into readability (LOC, username) values (?, ?)", 
        Statement.RETURN_GENERATED_KEYS)) {
    insert.setInt(readability.getLOC();
    insert.setString(readibility.getUser().getUsername());

    insert.executeUpdate();

    // handle generated keys...
}
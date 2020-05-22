// Use \" to escape the double-quotes, so that the query ends up like
    // UPDATE V_TEST SET "30" = ? WHERE V_MONTH = ?
    // In this case we have to use string concatenation to build up the query,
    // but we're only inserting an integer so this won't be a problem.
    String sql = "UPDATE V_TEST SET \"" + md + "\" = ? WHERE V_MONTH = ?";

    // stmt will need to be declared as a PreparedStatement, not a Statement.
    stmt = conn.prepareStatement(sql);

    // Set the values for the two '?' placeholders.
    stmt.setString(1, s[md]);
    stmt.setString(2, jan);

    int i = stmt.executeUpdate();
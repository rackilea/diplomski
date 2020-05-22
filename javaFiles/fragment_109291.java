try (PreparedStatement stmt = connection.prepareStatement(
        "select * from table_name WHERE NOTENAME = ?")) {
    stmt.setString(1, lstGetNotes.getSelectedValue());

    ResultSet result = stmt.executeQuery();
    if (result.next()) {
       ....
    }
}
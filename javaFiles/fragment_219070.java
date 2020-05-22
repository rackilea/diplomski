public boolean checkExist(String table, String info) {

    final String query = "SELECT EXISTS(SELECT 1 FROM " + table
            + " WHERE info = ?)";

    try (PreparedStatement st = con.prepareStatement(query,
             ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
        st.setString(1, info); // bind the variable to the placeholder
        try (ResultSet rs = st.executeQuery()) {
            if (rs.next()) {
                return rs.getBoolean(1); // EXISTS() returns a boolean
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
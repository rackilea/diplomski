try (PreparedStatement st = conn.prepareStatement(query)) {
    st.setLong(1, obiekty.id);
    ResultSet rs = st.executeQuery();
    // iterate over result set
} catch (SQLException ex) {
   // sensible handling!
}
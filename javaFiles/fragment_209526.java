private int isDuplicate(byte hash[]) throws SQLException {
    PreparedStatement stament = conn.prepareStatement("SELECT id_report from IDENT where hash = ?");
    stament.setBytes(1,hash);

    ResultSet st = stament.executeQuery();
    return st.next();
}
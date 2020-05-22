CustomDataContainer data = new CustomDataContainer();
Connection conn = null;
PreparedStatement prep = null;
ResultSet rs = null;

try {

    conn = getConnection(); // method returns a connection to your DB
    prep = conn.prepareStatement(STRING_REPRESENTING_YOUR_STATEMENT);
    rs = prep.executeQuery();

    while (rs.next()) {

       data.addData(rs.getString(1));
    }
} catch (Exception ex) {
    ex.printStackTrace();
    // re-throw ex
} finally {

    try { rs.close(); } catch (Exception ignore) {}
    try { prep.close(); } catch (Exception ignore) {}
    try { conn.close(); } catch (Exception ignore) {}
}

return data;
String sql = "UPDATE teachers SET password=? WHERE firstname=? AND lastname=?";
try (PreparedStatement pStat = con.prepareStatement(sql)) {
    Reader reader = new CharArrayReader(newPassword);
    pStat.setCharacterStream(1, reader);
    pStat.setString(2, firstName);
    pStat.setString(3, lastName);
    pStat.executeUpdate();
    pStat.clearParameters();
}
Arrays.fill(newPassword, ' ');
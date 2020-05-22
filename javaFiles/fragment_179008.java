char[] password = ...;
try (PreparedStatement stmt = con.prepareStatement("...")) {
    Reader reader = new CharArrayReader(password);
    stmt.setCharacterStream(1, reader);
    stmt.executeUpdate();
    stmt.clearParameters();
}
Arrays.fill(password, ' ');
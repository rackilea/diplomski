PreparedStatement ps = conn.prepareStatement(
   "UPDATE [Artists] SET [Website] = ? WHERE [ID] = ?"
);
String web = artist.getWebsite();
if (web == null) {
    ps.setNull(1, JDBCType.NVARCHAR);
} else {
    ps.setString(1, web);
}
ps.setInt(2), artist.getID());
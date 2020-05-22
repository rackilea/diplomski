String sql = "SELECT Losses FROM Players WHERE UUID='" + p.getUniqueId() + "';"; 
ResultSet rs = stmt.executeQuery(sql);
int losses = -1;
if(rs.next()) {
    losses = rs.getInt("Losses");
}
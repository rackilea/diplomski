String query = "exec rptGetAssetbyLocation ?";
Connection conn = DriverManager.getConnection(url, username, password);
CallableStatement stmt = conn.prepareCall(query);
stmt.setString(1, "2122");
ResultSet rs = stmt.executeQuery();
while (rs.next())
{
    int id = rs.getInt("ID");
    String tag = rs.getString("tag");
    String name = rs.getString("name"); 
    String model = rs.getString("model"); 
    String serNum = rs.getString("serialNumber");
    // ...and do other useful stuff
}
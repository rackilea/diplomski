String queryStringAlt = "CALL dbo.BronzeLabsCreateServiceEquipment(?, ?, ?, ?, ?, ?)";
CallableStatement cs = conn.prepareCall(queryStringAlt); 

    cs.setString(1, null);
    cs.setString(2, null);
    cs.setString(3, null);
    cs.setString(4, "new123-1");
    cs.setString(5, "new123-2");
    cs.setString(6, "new123-3");

ResultSet rs = cs.executeQuery();
if(rs.next()) {
    System.out.println("Equipment ID: " + rs.getString("equipmentID"));
}
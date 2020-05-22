String sql = 
        "SELECT slipNumber FROM Slip " + 
        "WHERE slipOpen = -1 AND slipLength >= ? AND slipDepth >= ? " +
        "LIMIT 1";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setDouble(1, boatLengthdub);  // assuming that they are Double values
ps.setDouble(2, boatDepthdub);
ResultSet rs = ps.executeQuery();
if (rs.next()) {
    System.out.println(rs.getInt("slipNumber"));
} else {
    System.out.println("Not found.");
}
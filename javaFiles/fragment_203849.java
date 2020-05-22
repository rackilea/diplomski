Class.forName(<driver class>);                
try (Connection con = DriverManager.getConnection(
        "IP", "username", "password")) {
    for(String dealId : items) {
        String sql= "SQL Query with " + dealId;
        // resources are opened by order 
        try (PreparedStatement preparedStatement = con.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {
            while(rs.next()) {
                count += rs.getInt("total");                    
            }
        } // resources are implicitly closed in reverse order of open
    }
} catch (Exception e) {
    e.printStackTrace();
}

System.out.println(count);
if(items.size() == count) {
    dealsBelongToTheParty = true;
}
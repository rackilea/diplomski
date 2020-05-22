ArrayList<List<String>> customerDetails = new ArrayList<>(25);
String sqlQuery = "SELECT * FROM customer WHERE AccountNumber=?";
try (PreparedStatement stmt = DatabaseConnection.dBconn().prepareStatement(sqlQuery)) {
    stmt.setString(1, accountNumber);
    try (ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            List<String> rowDetails = new ArrayList<>(10);
            rowDetails.add(rs.getString("Name"));
            rowDetails.add(rs.getString("DoB"));
            rowDetails.add(rs.getString("Address"));
            rowDetails.add(rs.getString("Mobile"));
            rowDetails.add(rs.getString("Email"));
            rowDetails.add(rs.getString("AccountType"));
            rowDetails.add(rs.getString("AccountNumber"));
            rowDetails.add(rs.getString("SortCode"));
            rowDetails.add(rs.getString("Balance"));
            rowDetails.add(rs.getString("Card"));

            customerDetails.add(rowDetails);
        }
    }

} catch (SQLException err) {
    System.out.println(err.getMessage());
}
return customerDetails;
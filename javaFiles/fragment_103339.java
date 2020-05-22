public ArrayList<String> getWalletTag() throws SQLException {
   String query = "SELECT Tag FROM Wallets;";
   ...
   resultset = statement.executeQuery(query);
   List<String> tags = new ArrayList<String>();
   while (resultset.next()) {
     tags.add(resultset.getString("Tag"));
     ...
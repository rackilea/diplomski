public ArrayList<Wallet> getAllWallets() throws SQLException{
   resultset = statement.executeQuery(query);
   while (resultset.next()) {
     Wallet w = new Wallet(query, 0, query);
     w.setName(resultset.getString("Name"));
     w.setLocation(resultset.getInt("Location"));
     w.setTag(resultset.getString("Tag"));
     list.add(w);
   }   
   ...
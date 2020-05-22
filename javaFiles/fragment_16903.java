public Items getItemDetails() {
   Connection con = connect(true);
   PreparedStatement stmt = null;
   ResultSet rs = null;
   String select = "SELECT * FROM TEST.ITEMBOUGHT WHERE ITEM_ID = ?";
   Items item = null;

   try {
       stmt = con.prepareStatement(select);
       stmt.setInt(1,1);
       rs = stmt.executeQuery();
       while (rs.next()) {
          ... // and so on
       }
   }
   ...
}
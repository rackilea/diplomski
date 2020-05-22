ResultSet rs = statement.executeQuery("select language from language order by 1");
while (rs.next()) {
   langbox.addItem(rs.getString(1));
   //I'm thinking that this is where a default value would be located
   if(rs.getString(1).equals(myDefaultLanguageVariable)) {
      langbox.setSelectedItem(rs.getString(1));
   }
}
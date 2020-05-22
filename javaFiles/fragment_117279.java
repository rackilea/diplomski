ResultSet set = statement.executeQuery();
   while(set.next()) {
       if(set.getString(1).toLowerCase()
              .contains(keyword.toLowerCase)) {
           list.put(set.getString(2), set.getString(1));
       }
   }
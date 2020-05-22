ResultSet result = statement.executeQuery();

   while(result.next()){
       String productName = result.getString(1);
       String productId = result.getString(2); // ???? not sure if this is valid
       MyComboItem comboItem = new MyComboItem(productId, productName);
       comboModel.addElement(comboItem);
   }
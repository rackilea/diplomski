ResultSet results = myStatement.executeQuery(sql);

 ResultSetMetaData meta = results.getMetaData();
 for (int index = 1; index <= meta.getColumnCount(); index++)
 {
    System.out.println("Column " + index + " is named " + meta.getColumnName(index);
 }
 while (results.next()){
     itemDescription = results.getString(1);
     itemPrice = results.getInt(2);
     item = new Item(itemDescription, itemPrice);
 }
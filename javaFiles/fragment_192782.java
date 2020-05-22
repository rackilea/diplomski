for (Map.Entry <String, HashMap <String, Integer>> nameEntry: mainHash) {
     String name = nameEntry.getKey();
     for (Map.Entry <String, Integer> productEntry: nameEntry.getValue ()) {
         String product = productEntry.getKey();
         Integer quantity = productEntry.getValue();
          db.execSQL("Insert into table(name, product , quantity) values ('" + name + "', '" + product + "' + " + quantity + ")");
     }
}
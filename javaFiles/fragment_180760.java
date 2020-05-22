for (int i = 0; i < ouputTable.getNumRows(); i++) {
   outputTable.setRow(i);
   Iterator it = displayField.iterator();
   // get fields of current record
   while(it.hasNext()){
      String fieldName = (String)it.next();
      String value = outputTable.getString(fieldName);
      // do what you need to do with the field and value
   }
}
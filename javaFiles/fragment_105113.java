openDB();
     Cursor c = myDb.getSpalte();
     List<Integer> valueList = new ArrayList<Integer>(c.getCount());

     List<Integer> tenthRows = new ArrayList<Integer>();
     counter = 0;
     while (c.moveToNext()) {  
         Integer value = c.getInt(1);      
         valueList.add(value );
         counter++;
         if(counter == 10) {
             tenthRows.add(value)
             counter = 0;
         }
     }
     c.close();
     closeDB();
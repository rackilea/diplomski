while(rowIterator.hasNext()) 
  {
   count=0;
   Row row = rowIterator.next();

   if(row.getRowNum()==0){
      continue; //just skip the rows if row number is 0
  }
    JsonObjectBuilder userjson = Json.createObjectBuilder();
   Iterator<Cell> cellIterator = row.cellIterator();
   while(cellIterator.hasNext()) {                
       Cell cell = cellIterator.next();
       if(count == 0)   {
       userjson.add("email", cell.getStringCellValue());
       } else if(count == 1)    {
            userjson.add("firstname", cell.getStringCellValue());
        } else if(count == 2)   {
            userjson.add("lastname", cell.getStringCellValue());
        } else if(count == 3)   {
            userjson.add("password", cell.getStringCellValue());
        }
       count ++;

   }

blist.add(userjson.build());
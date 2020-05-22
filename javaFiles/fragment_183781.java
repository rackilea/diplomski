Sheet sheet = wb.getSheetAt(0);
Iterator<Row> rowIte =  sheet.iterator();
while(rowIte.hasNext()){
  rowIte.next();              
  rowIte.remove();
 }
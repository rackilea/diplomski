public void fileIterator() throws IOException{
  HSSFWorkbook my_wb = new HSSFWorkbook();                        
  BufferedOutputStream bos= new BufferedOutputStream(new FileOutputStream("copiedWB.xls")); //create the BufferedOutputStream only for the fileIterator method
  for(int i = 0; i < 3; i++){
   add_in_excel(my_wb, "file" + i);
   System.out.println("In file :" + "file" + i);
  }
  my_wb.write(bos);
  bos.close();  //write into and close the BufferedOutputStream only once after you have added all sheets.
 }

 private void add_in_excel(HSSFWorkbook copy_wb, String file) throws IOException {
  HSSFSheet mySheet =  copy_wb.createSheet(file);
 }
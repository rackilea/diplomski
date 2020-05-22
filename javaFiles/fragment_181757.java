//This will work, but is not recommend
 public void fileIterator() throws IOException{
  HSSFWorkbook my_wb = new HSSFWorkbook();                        
  for(int i = 0; i < 3; i++){
   BufferedOutputStream bos= new BufferedOutputStream(new FileOutputStream("copiedWB.xls")); // creating a new BufferedOutputStream for each call of add_in_excel
   add_in_excel(my_wb, bos,"file" + i);
   System.out.println("In file :" + "file" + i);
  }
 }

 private void add_in_excel(HSSFWorkbook copy_wb, BufferedOutputStream bos, String file) throws IOException {
  HSSFSheet mySheet =  copy_wb.createSheet(file);
  copy_wb.write(bos);
  bos.close(); //write the copy_wb with one new added sheet into the BufferedOutputStream and close it.
 }
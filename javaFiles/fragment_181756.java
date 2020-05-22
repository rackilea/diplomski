import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedOutputStream;

class CreateSingleExcelFile {

 public static void main(String[] args) throws IOException {
  CreateSingleExcelFile cef = new CreateSingleExcelFile();
  cef.fileIterator();
 }

//This is what you actual doing:
 public void fileIterator() throws IOException{
  HSSFWorkbook my_wb = new HSSFWorkbook();                        
  BufferedOutputStream bos= new BufferedOutputStream(new FileOutputStream("copiedWB.xls"));
  for(int i = 0; i < 3; i++){
   add_in_excel(my_wb, bos,"file" + i);
   System.out.println("In file :" + "file" + i);
  }
  bos.close(); //closing the BufferedOutputStream. The resulting file contains bytes for 3 complete XLS files. 
 }

 private void add_in_excel(HSSFWorkbook copy_wb, BufferedOutputStream bos, String file) throws IOException {
  HSSFSheet mySheet =  copy_wb.createSheet(file);
  copy_wb.write(bos); //write the copy_wb with one new added sheet into the BufferedOutputStream without closing it. But writing a XLS file is complex. So this will not work properly. It will append bytes for a complete XLS workbook onto the stream.
 }
}
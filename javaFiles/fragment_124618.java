import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.*;

import org.apache.poi.ss.util.CellRangeAddress;

import org.apache.poi.hssf.record.RecordBase;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.hssf.model.InternalSheet;
import org.apache.poi.util.LittleEndianOutput;

import java.lang.reflect.Field;

import java.util.List;

public class CreateExcelHSSFProtectedSheet {

 public static void main(String[] args) throws Exception {

  HSSFWorkbook workbook = new HSSFWorkbook();
  HSSFSheet sheet = workbook.createSheet();

  sheet.setAutoFilter(CellRangeAddress.valueOf("A1:C3"));
  HSSFRow row = sheet.createRow(0);
  for (int c = 0; c < 3; c++) {
   row.createCell(c).setCellValue("Col " + (c+1));
  }

  for (int r = 1; r < 4; r++) {
   row = sheet.createRow(r);
   for (int c = 0; c < 3; c++) {
    row.createCell(c).setCellValue(r * (c+1)); 
   }
  }

  sheet.protectSheet("");
  Field _sheet = HSSFSheet.class.getDeclaredField("_sheet");
  _sheet.setAccessible(true); 
  InternalSheet internalsheet = (InternalSheet)_sheet.get(sheet); 

  Field _records = InternalSheet.class.getDeclaredField("_records");
  _records.setAccessible(true);
  @SuppressWarnings("unchecked") 
  List<RecordBase> records = (List<RecordBase>)_records.get(internalsheet);

  SheetProtectionRecord sheetprotection = new SheetProtectionRecord();
  sheetprotection.lockAutoFilter(false);
  sheetprotection.lockInsertRows(false);
  sheetprotection.lockInsertHyperlinks(false);

  records.add(records.size() - 1, sheetprotection); 

/*  
  for (RecordBase r : internalsheet.getRecords()) {
   System.out.println(r);
  }
*/

  FileOutputStream out = new FileOutputStream("CreateExcelHSSFProtectedSheet.xls");
  workbook.write(out);
  out.close();
  workbook.close();

 }

 static class SheetProtectionRecord extends StandardRecord {

  //see https://www.openoffice.org/sc/excelfileformat.pdf#%5B%7B%22num%22%3A635%2C%22gen%22%3A0%7D%2C%7B%22name%22%3A%22XYZ%22%7D%2C85.6%2C771.1%2C0%5D

  byte[] data = new byte[]{(byte)0x67, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x02, 0x00, 0x01,  (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF, 0x00, (byte)0x44, 0x00, 0x00};

  public int getDataSize() { 
   return 23; 
  }

  public short getSid() {
   return (short)0x0867;
  }

  void lockAutoFilter(boolean lock) {
   if(lock) data[20] &= 0xEF;
   else data[20] |= 0x10;
  } 

  void lockSelectLockedCells(boolean lock) {
   if(lock) data[20] &= 0xFB;
   else data[20] |= 0x04;
  }

  void lockSelectUnLockedCells(boolean lock) {
   if(lock) data[20] &= 0xBF;
   else data[20] |= 0x40;
  }

  void lockInsertRows(boolean lock) {
   if(lock) data[19] &= 0xBF;
   else data[19] |= 0x40;
  }

  void lockInsertHyperlinks(boolean lock) {
   if(lock) data[19] &= 0x7F;
   else data[19] |= 0x80;
  }
  //further methods ....

  public void serialize(LittleEndianOutput out) {
   out.write(data);
  }
 }

}
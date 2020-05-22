import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xwpf.usermodel.*;

class ReadExcelWriteWord {

 public static void main(String[] args) throws Exception {

  DataFormatter formatter = new DataFormatter();

  Workbook workbook = WorkbookFactory.create(new FileInputStream("convertion java.xls"));
  FileOutputStream out = new FileOutputStream("output.docx");
  XWPFDocument document = new XWPFDocument();

  Sheet sheet = workbook.getSheetAt(0);
  Row row = null;
  Cell cell = null;
  XWPFParagraph paragraph = null;
  XWPFRun run = null;

  String[] header = new String[4];
  row = sheet.getRow(0);
  if (row != null) {
   for (int k = 0; k < 4; k++) {
    cell = row.getCell(k);
    header[k] = formatter.formatCellValue(cell);
   }
  }

  String result = "";
  String doc = "";
  for (int j = 1; j < 5; j++) {
   row = sheet.getRow(j);
   if (row != null) {
    for (int i = 0; i < 4; i++) {
     cell = row.getCell(i);
     result = formatter.formatCellValue(cell);
     doc = header[i] + " = " + result;
     System.out.println(doc);
     paragraph = document.createParagraph();
     run = paragraph.createRun();
     run.setText(doc);
    }
   }
   paragraph = document.createParagraph();
   System.out.println();
  }

  workbook.close();
  document.write(out);
  out.close();
  document.close();
 }
}
import java.io.File;
import java.io.FileOutputStream;

import java.math.BigInteger;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;

public class CreateWordTableMerge3 {

 static void mergeCellVertically(XWPFTable table, int col, int fromRow, int toRow) {
  for(int rowIndex = fromRow; rowIndex <= toRow; rowIndex++) {
   XWPFTableCell cell = table.getRow(rowIndex).getCell(col);
   CTVMerge vmerge = CTVMerge.Factory.newInstance();
   if(rowIndex == fromRow){
    // The first merged cell is set with RESTART merge value
    vmerge.setVal(STMerge.RESTART);
   } else {
    // Cells which join (merge) the first one, are set with CONTINUE
    vmerge.setVal(STMerge.CONTINUE);
    // and the content should be removed
    for (int i = cell.getParagraphs().size(); i > 0; i--) {
     cell.removeParagraph(0);
    }
    cell.addParagraph();
   }
   // Try getting the TcPr. Not simply setting an new one every time.
   CTTcPr tcPr = cell.getCTTc().getTcPr();
   if (tcPr == null) tcPr = cell.getCTTc().addNewTcPr();
   tcPr.setVMerge(vmerge);
  }
 }

 //merging horizontally by setting grid span instead of using CTHMerge
 static void mergeCellHorizontally(XWPFTable table, int row, int fromCol, int toCol) {
  XWPFTableCell cell = table.getRow(row).getCell(fromCol);
  // Try getting the TcPr. Not simply setting an new one every time.
  CTTcPr tcPr = cell.getCTTc().getTcPr();
  if (tcPr == null) tcPr = cell.getCTTc().addNewTcPr();
  // The first merged cell has grid span property set
  if (tcPr.isSetGridSpan()) {
   tcPr.getGridSpan().setVal(BigInteger.valueOf(toCol-fromCol+1));
  } else {
   tcPr.addNewGridSpan().setVal(BigInteger.valueOf(toCol-fromCol+1));
  }
  // Cells which join (merge) the first one, must be removed
  for(int colIndex = toCol; colIndex > fromCol; colIndex--) {
   table.getRow(row).getCtRow().removeTc(colIndex);
   table.getRow(row).removeCell(colIndex);
  }
 }

 static void setColumnWidth(XWPFTable table, int row, int col, int width) {
  CTTblWidth tblWidth = CTTblWidth.Factory.newInstance();
  tblWidth.setW(BigInteger.valueOf(width));
  tblWidth.setType(STTblWidth.DXA);
  CTTcPr tcPr = table.getRow(row).getCell(col).getCTTc().getTcPr();
  if (tcPr != null) {
   tcPr.setTcW(tblWidth);
  } else {
   tcPr = CTTcPr.Factory.newInstance();
   tcPr.setTcW(tblWidth);
   table.getRow(row).getCell(col).getCTTc().setTcPr(tcPr);
  }
 }

 public static void main(String[] args) throws Exception {

  XWPFDocument document= new XWPFDocument();

  XWPFParagraph paragraph = document.createParagraph();
  XWPFRun run=paragraph.createRun();  
  run.setText("The table:");

  //create table
  //4 rows 9 columns
  XWPFTable table = document.createTable(4,9);

  for (int row = 0; row < 4; row++) {
   for (int col = 0; col < 9; col++) {
    //table.getRow(row).getCell(col).setText("row " + row + ", col " + col);
    if (row < 3) { // header rows
     table.getRow(row).getCell(col).setColor("D9D9D9"); // header rows color
     table.getRow(row).setRepeatHeader(true); // header rows shall repeat on new pages
    }
   }
  }

  //defining the column widths for the grid
  //column width values are in unit twentieths of a point (1/1440 of an inch)
  int defaultColWidth = 1*1440*6/9; // 9 columns fits to 6 inches 
  int[] colunmWidths = new int[] {
   defaultColWidth, defaultColWidth, defaultColWidth, defaultColWidth, 
   defaultColWidth, defaultColWidth, defaultColWidth, defaultColWidth, defaultColWidth
  };

  //create CTTblGrid for this table with widths of the 8 columns. 
  //necessary for Libreoffice/Openoffice to accept the column widths.
  //first column
  table.getCTTbl().addNewTblGrid().addNewGridCol().setW(BigInteger.valueOf(colunmWidths[0]));
  //other columns
  for (int col = 1; col < colunmWidths.length; col++) {
   table.getCTTbl().getTblGrid().addNewGridCol().setW(BigInteger.valueOf(colunmWidths[col]));
  }

  //using the merge methods and setting the column widths
  //horizontally merge all columns in first row
  mergeCellHorizontally(table, 0, 0, 8); 
  setColumnWidth(table, 0, 0, colunmWidths[0]+colunmWidths[1]+colunmWidths[2]+colunmWidths[3]
                              +colunmWidths[4]+colunmWidths[5]+colunmWidths[6]+colunmWidths[7]+colunmWidths[8]);

  //horizontally merge last two columns in second row
  mergeCellHorizontally(table, 1, 7, 8); 
  setColumnWidth(table, 1, 7, colunmWidths[7]+colunmWidths[7]);

  //vertically merge row 2 and 3 in column 1 to 7
  for (int c = 0; c < 7; c++) {
   mergeCellVertically(table, c, 1, 2);
  }

  //add more rows to fill the page; note: for apache poi the table has only one column because of all the merging
  for (int row = 4; row < 50; row++) {
   XWPFTableRow tableRow = table.createRow();
   for (int col = 1; col < 9; col++) {
    tableRow.createCell();
   }
  }

  paragraph = document.createParagraph();

  FileOutputStream out = new FileOutputStream("create_table.docx"); 
  document.write(out);
  out.close();

 }
}
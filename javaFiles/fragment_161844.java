import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.ss.SpreadsheetVersion;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;

class ExcelExpandingTable {

 static void addRowToTable(XSSFTable table) {

   int lastTableRow = table.getEndCellReference().getRow();
   int totalsRowCount = table.getTotalsRowCount();
   int lastTableDataRow = lastTableRow - totalsRowCount;

   // we will add one row in table data
   lastTableRow++;
   lastTableDataRow++;

   // new table area plus one row
   AreaReference newTableArea = new AreaReference(
                                 table.getStartCellReference(), 
                                 new CellReference(
                                  lastTableRow, 
                                  table.getEndCellReference().getCol()
                                 ),
                                 SpreadsheetVersion.EXCEL2007
                                );

   // new table data area plus one row
   AreaReference newTableDataArea = new AreaReference(
                                     table.getStartCellReference(), 
                                      new CellReference(
                                       lastTableDataRow, 
                                       table.getEndCellReference().getCol()
                                      ),
                                      SpreadsheetVersion.EXCEL2007
                                    );

   XSSFSheet sheet = table.getXSSFSheet();
   if (totalsRowCount > 0) {
    //if we have totals rows, shift totals rows down
    sheet.shiftRows(lastTableDataRow, lastTableRow, 1);

    // correcting bug that shiftRows does not adjusting references of the cells
    // if row 3 is shifted down, then reference in the cells remain r="A3", r="B3", ...
    // they must be adjusted to the new row thoug: r="A4", r="B4", ...
    // apache poi 3.17 has done this properly but had have other bugs in shiftRows.
    for (int r = lastTableDataRow; r < lastTableRow + 1; r++) {
     XSSFRow row = sheet.getRow(r); 
     if (row != null) {
      long rRef = row.getCTRow().getR();
      for (Cell cell : row) {
       String cRef = ((XSSFCell)cell).getCTCell().getR();
       ((XSSFCell)cell).getCTCell().setR(cRef.replaceAll("[0-9]", "") + rRef);
      }
     }
    }
    // end correcting bug

   }

   // if there are CalculatedColumnFormulas do filling them to the new row
   XSSFRow row = sheet.getRow(lastTableDataRow); if (row == null) row = sheet.createRow(lastTableDataRow);
   for (CTTableColumn tableCol : table.getCTTable().getTableColumns().getTableColumnList()) {
    if (tableCol.getCalculatedColumnFormula() != null) {
     int id = (int)tableCol.getId();
     String formula = tableCol.getCalculatedColumnFormula().getStringValue();
     XSSFCell cell = row.getCell(id -1); if (cell == null) cell = row.createCell(id -1);
     cell.setCellFormula(formula);
    }
   }

   table.setArea(newTableArea);

   // correcting bug that Autofilter includes possible TotalsRows after setArea new
   // Autofilter must only contain data area
   table.getCTTable().getAutoFilter().setRef(newTableDataArea.formatAsString());
   // end correcting bug

   table.updateReferences();

 }

 public static void main(String[] args) throws Exception {
  try (Workbook workbook = WorkbookFactory.create(new FileInputStream("SAMPLE.xlsx"));
       FileOutputStream out = new FileOutputStream("SAMPLE_NEW.xlsx")) {

   XSSFSheet sheet = ((XSSFWorkbook)workbook).getSheetAt(0);
   XSSFTable table = sheet.getTables().get(0);

   addRowToTable(table);

   workbook.write(out);
  } 
 }
}
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import java.io.*;

class UsingCellReferenceInFormula {

 public static void main(String[] args) throws IOException{

    String[][] data = new String[][]{
                          {"Number1","Number2","Sum","Complex"},
                          {"123","456", null, null},
                          {"23.45","67.89", null, null},
                          {"123","-456", null, null},
                          {"-123.456","456.78", null, null}
                      };

    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet();

    int r = 0;
    for(String[] dataRow : data){
        Row row = sheet.createRow(r++);
        int c = 0;
        for(String dataCell : dataRow){
            Cell cell = row.createCell(c++);
            if ( r == 1 ) cell.setCellValue(dataCell);
            else if ( c < 3 ) cell.setCellValue(Double.parseDouble(dataCell));
            else if ( c == 3 ) {
                CellReference cellReference = new CellReference(cell);
                String thisR = cellReference.getCellRefParts()[1]; 
                cell.setCellFormula("SUM(A" + thisR + ":B" + thisR + ")");
            } else if ( c == 4 ) {
                CellReference cellReference = new CellReference(cell);
                String thisR = cellReference.getCellRefParts()[1]; 
                cell.setCellFormula("IF(AND(A" + thisR + ">0,B" + thisR + ">0),SUM(A" + thisR + ":B" + thisR + "),MAX(A" + thisR + ":B" + thisR + "))");
            }
        }
    }


    FileOutputStream fileOut = new FileOutputStream("UsingCellReferenceInFormula.xlsx");
    workbook.write(fileOut);
    workbook.close();

 }
}
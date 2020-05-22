import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestProblem

{
    public static void main(String[] args) throws IOException {


        InputStream inp = null;
        inp = new FileInputStream("E:\\Projects\\PoiAdvanceExample\\stackProblem.xlsx");

        Workbook wb = WorkbookFactory.create(inp);
        Sheet sheet = wb.getSheetAt(0);

        int rowsCount = sheet.getLastRowNum();
        int columnCount = sheet.getRow(0).getLastCellNum();
        String[][] inputData = new String[rowsCount+1][columnCount];

        for (int i = 0; i <= rowsCount; i++) {
            Row row = sheet.getRow(i);
            int colCounts = row.getLastCellNum();
            for (int j = 0; j < colCounts; j++) {
                Cell cell = row.getCell(j);
                if(cell.getCellType() == CellType.NUMERIC) {
                    inputData[i][j] = Double.toString(cell.getNumericCellValue());
                }
                if(cell.getCellType() == CellType.FORMULA) {
                    inputData[i][j] = cell.getCellFormula();
                }
                if(cell.getCellType() == CellType.STRING) {
                    inputData[i][j] = cell.getStringCellValue();
                }
            }
        }

       writeData(inputData);

    }

    private static void writeData(String[][] inputData) throws IOException {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        int r = 0;
        for (String[] dataRow : inputData) {
            Row row = sheet.createRow(r++);
            int column = 0;
            for (String dataCell : dataRow) {
                Cell cell = row.createCell(column++);
                if (r == 1 || column == 1) cell.setCellValue(dataCell);

                else if (column == 2) {
                    CellReference cellReference = new CellReference(cell);
                    String thisR = cellReference.getCellRefParts()[1];
                    cell.setCellFormula("LEFT(A" + thisR + ",2)");
                }
            }
        }


        FileOutputStream fileOut = new FileOutputStream("stackProblem.xlsx");
        workbook.write(fileOut);
        workbook.close();
    }
}
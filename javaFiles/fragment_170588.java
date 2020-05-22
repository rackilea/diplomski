import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public static String[][] readDataExcel(String TableName) {
        String filePath = "src/test/resources/Testdata.xlsx";
        try {
            Workbook workbook = new XSSFWorkbook(filePath);
            XSSFSheet sheet = (XSSFSheet) workbook.getSheet("UnitTest");
            List<XSSFTable> tables = sheet.getTables();

            for (XSSFTable table : tables) {
                String name = table.getName();
                if (! name.equals(TableName)) {
                    continue;
                }
                int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
                System.out.println(rowCount);
                int columnCount = - 1;
                List<List<String>> data = new ArrayList<>();
                for (int i = 1; i < rowCount + 1; i++) {
                    Row row = sheet.getRow(i);
                    int colNum = row.getLastCellNum();
                    if (columnCount == - 1) {
                        columnCount = colNum;
                    }
                    List<String> rowData = new ArrayList<>();
                    for (int j = 0; j < colNum; j++) {
                        Cell cell = row.getCell(j);
                        DataFormatter formatter = new DataFormatter();
                        String var_name = formatter.formatCellValue(cell);
                        if (var_name != null && ! var_name.trim().isEmpty()) {
                            rowData.add(var_name);
                        }
                    }
                    if (! rowData.isEmpty()) {
                        data.add(rowData);
                    }
                }
                workbook.close();
                String[][] dataArray = new String[rowCount-1][columnCount];
                int rowIndex = 0;
                for (List<String> row : data) {
                    int colIndex = 0;
                    for (String rowData : row) {
                        dataArray[rowIndex][colIndex++] = rowData;
                    }
                    rowIndex++;
                }
                return dataArray;
            }
            System.err.println("Table name is incorrect");
            return new String[][] {{}};
        } catch (Exception e) {
            e.printStackTrace();
            return new String[][] {{}};
        }
    }
}
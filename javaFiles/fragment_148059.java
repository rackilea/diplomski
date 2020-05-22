package POIParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MainPoi {

    public static void main(String[] args) throws Exception {

        File excel = new File("test.xlsx");
        FileInputStream fis = new FileInputStream(excel);

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet ws = wb.getSheetAt(0);
        ws.setForceFormulaRecalculation(true);

        int rowNum = ws.getLastRowNum() + 1;
        int colNum = ws.getRow(0).getLastCellNum();
        int surnameHeaderIndex = -1, valueHeaderIndex = -1;

        // Read the headers first. Locate the ones you need
        XSSFRow rowHeader = ws.getRow(0);
        for (int j = 0; j < colNum; j++) {
            XSSFCell cell = rowHeader.getCell(j);
            String cellValue = cellToString(cell);
            if ("SURNAME".equalsIgnoreCase(cellValue)) {
                surnameHeaderIndex = j;
            } else if ("VALUE".equalsIgnoreCase(cellValue)) {
                valueHeaderIndex = j;
            }
        }

        if (surnameHeaderIndex == -1 || valueHeaderIndex == -1) {
            throw new Exception("Could not find header indexes\nSurname : "
                    + surnameHeaderIndex + " | Value : " + valueHeaderIndex);
        }
        // createnew workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        // Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("data");

        for (int i = 1; i < rowNum; i++) {
            XSSFRow row = ws.getRow(i);
            String surname = cellToString(row.getCell(surnameHeaderIndex));
            String value = cellToString(row.getCell(valueHeaderIndex));
            int cellIndex = 0;
            //Create a newRow object for the output excel. 
            //We begin for i = 1, because of the headers from the input excel, so we go minus 1 in the new (no headers).
            //If for the output we need headers, add them outside this for loop, and go with i, not i-1
            XSSFRow newRow = sheet.createRow(i-1);  
            newRow.createCell(cellIndex++).setCellValue(surname);
            newRow.createCell(cellIndex++).setCellValue(value);
        }

        FileOutputStream fos = new FileOutputStream(new File("test1.xlsx"));
        workbook.write(fos);
        fos.close();
    }

    public static String cellToString(XSSFCell cell) {

        int type;
        Object result = null;
        type = cell.getCellType();

        switch (type) {

        case XSSFCell.CELL_TYPE_NUMERIC:
            result = BigDecimal.valueOf(cell.getNumericCellValue())
                    .toPlainString();

            break;
        case XSSFCell.CELL_TYPE_STRING:
            result = cell.getStringCellValue();
            break;
        case XSSFCell.CELL_TYPE_BLANK:
            result = "";
            break;
        case XSSFCell.CELL_TYPE_FORMULA:
            result = cell.getCellFormula();
        }

        return result.toString();
    }
}
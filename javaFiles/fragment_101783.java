import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {

    private static final String FILE_NAME = "/users/developer/Documents/myFile.xlsx";

    public void employeesUpload() {
        String fName = "";
        String lName = "";
        String phoneNumber = "";
        String email = "";
        String gender = "";
        String employeeCode = "";

        try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            int rowIndex = 0;
            DataFormatter formatter = new DataFormatter();
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                if (rowIndex > 0) {
                    Iterator<Cell> cellIterator = currentRow.iterator();

                    employeeCode = fName = lName = phoneNumber = email = gender = "";

                    int cellIndex = 0;
                    while (cellIndex <= 5) {

                        Cell currentCell = currentRow.getCell(cellIndex);
                        if (cellIndex == 4) {
                            employeeCode = formatter.formatCellValue(currentCell).trim();
                        }

                        if (cellIndex == 1) {
                            fName = formatter.formatCellValue(currentCell).trim();
                        }

                        if (cellIndex == 2) {
                            lName = formatter.formatCellValue(currentCell).trim();
                        }

                        if (cellIndex == 0) {
                            email = formatter.formatCellValue(currentCell);
                            email = email.trim().toLowerCase();
                        }

                        if (cellIndex == 3) {
                            phoneNumber = formatter.formatCellValue(currentCell).trim();
                        }

                        cellIndex++;
                    }
                    Cell resultCell = currentRow.getCell(7);

                    if (resultCell == null) {
                        resultCell = currentRow.createCell(7);
                    }

                    Cell employementIdCell = currentRow.getCell(8);
                    if (employementIdCell == null) {
                        employementIdCell = currentRow.createCell(8);
                    }

                    if (true) {
                        resultCell.setCellType(Cell.CELL_TYPE_STRING);
                        employementIdCell.setCellValue("Success");
                        resultCell.setCellValue(email);

                    } else {
                        resultCell.setCellType(Cell.CELL_TYPE_STRING);
                        resultCell.setCellValue("Error");
                    }

                }
                rowIndex++;
            }

            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws ParseException, UnsupportedEncodingException {

        Test employeesBulkUpload = new Test();
        employeesBulkUpload.employeesUpload();

    }
}
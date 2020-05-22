import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataUpdater {

    public static void exportDataToExcel(String fileName, String tabName, String[][] data)
            throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException, Exception {
        // Create new workbook and tab
        FileInputStream inputStream = null;
        Workbook wb;
        Sheet sheet = null;

        // Check the file extension
        if (!fileName.endsWith(".xls")) {
            throw new IllegalArgumentException("Unknown file type. Please use .xls");
        }

        File newFile = new File(fileName);

        // If file not exists we create a new workbook
        if (!newFile.exists()) {
            wb = new HSSFWorkbook();
        } else {
            // If file exists, we open an input stream channel to it
            inputStream = new FileInputStream(newFile);
            // Provide the input stream to WorkbookFactory
            wb = WorkbookFactory.create(inputStream);
        }

        // Check if the workbook is empty or not
        boolean isSheetFound = false;
        for (int i = 0; i < wb.getNumberOfSheets(); i++) {
            if (wb.getSheetName(i).equals(tabName)) {
                sheet = wb.getSheet(tabName);
                isSheetFound = true;
            }
        }
        if (!isSheetFound) {
            sheet = wb.createSheet(tabName);
        }

        // Create 2D Cell Array
        Row[] row = new Row[data.length];
        Cell[][] cell = new Cell[row.length][];
        // Define and Assign Cell Data from Given
        for (int i = 0; i < row.length; i++) {
            row[i] = sheet.createRow(i);
            cell[i] = new Cell[data[i].length];

            for (int j = 0; j < cell[i].length; j++) {
                cell[i][j] = row[i].createCell(j);
                cell[i][j].setCellValue(data[i][j]);
            }
        }

        // If file already exists, we had opened an input stream.
        // We will close this here
        if (inputStream != null)
            inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(newFile);

        // Export Data
        wb.write(outputStream);
        outputStream.close();
        wb.close();
        System.out.println("File exported successfully");
    }

    public static void main(String[] args)
            throws InvalidFormatException, EncryptedDocumentException, FileNotFoundException, IOException, Exception {
        String data1[][] = { { "A", "B", "C", "D" } };
        ExcelDataUpdater.exportDataToExcel("TestResultData2.xls", "Results1", data1);

        String data2[][] = { { "X", "Y", "Z", "W" } };
        ExcelDataUpdater.exportDataToExcel("TestResultData2.xls", "Results2", data2);
    }
}
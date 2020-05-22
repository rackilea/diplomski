import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SimpleSheet {

    public static void main(String[] args) throws IOException {
        Workbook wb = new XSSFWorkbook();
        Sheet sh1 = wb.createSheet("Sheet1");
        Row r = sh1.createRow(0);
        Cell c = r.createCell(0);
        c.setCellValue("Test");

        // Write the output to a file
        String file = "simple-poi.xlsx";
        FileOutputStream out = new FileOutputStream(file);
        wb.write(out);
        out.close();
        wb.close();
        System.out.println("Generated: " + file);
    }

}
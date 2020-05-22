import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ManualXlsxTest {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Workbook wb = new XSSFWorkbook();
        wb.createSheet("new sheet");
        File tempXlsx = File.createTempFile("temp", ".xlsx");
        wb.write(new FileOutputStream(tempXlsx));
        Desktop.getDesktop().open(tempXlsx);
    }
}
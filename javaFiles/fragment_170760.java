import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ModifySheet {

    public static void main(String[] args) throws Exception {
        String fileName = "MyExcel.xlsx";

        // load the workbook
        InputStream inp = new FileInputStream(fileName);
        Workbook wb = WorkbookFactory.create(inp);
        inp.close();

        // make some changes
        Sheet sh = wb.getSheetAt(0);
        Row r = sh.createRow(sh.getPhysicalNumberOfRows());
        Cell c = r.createCell(0);
        c.setCellValue(555);
        c = r.createCell(1);
        c.setCellValue(777);

        // overwrite the workbook with changed workbook
        FileOutputStream fileOut = new FileOutputStream(fileName);
        wb.write(fileOut);
        fileOut.close();
        wb.close();
    }
}
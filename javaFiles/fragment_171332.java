import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class StackOverflowQuestion18095443 {

    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Please specify the file name as a parameter");
            System.exit(-1);
        }
        String sfilename = args[0];
        File file = new File("C:\\Users\\student3\\" + sfilename + ".xls");
        read(file);
    }

    public static void read(File file) {
        try (InputStream in = new FileInputStream(file)) {
            HSSFDataFormatter formatter = new HSSFDataFormatter();
            Workbook workbook = WorkbookFactory.create(in);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                StringBuilder rowText = new StringBuilder();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String cellAsStringValue = formatter.formatCellValue(cell);
                    rowText.append(cellAsStringValue).append(" ");
                }
                System.out.println(rowText.toString().trim());
            }
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}
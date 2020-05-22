import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;   
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PoiWriteExcelFile {

public void methodOne() {

    System.out.println("Into method one!");

    Workbook wb = new HSSFWorkbook();
    Font f = wb.createFont();
    f.setBoldweight(Font.BOLDWEIGHT_BOLD);
    CellStyle cs = wb.createCellStyle();
    cs.setFont(f);

    CreationHelper createHelper = wb.getCreationHelper();
    Sheet sheet = wb.createSheet("First Sheet");
    Row row = sheet.createRow((short) 0);

    Cell c = null;

    c = row.createCell(0);
    c.setCellStyle(cs);
    c.setCellValue(createHelper.createRichTextString("First Column"));

    c = row.createCell(1);
    c.setCellStyle(cs);
    c.setCellValue(createHelper.createRichTextString("Second Column"));

    c = row.createCell(2);
    c.setCellStyle(cs);
    c.setCellValue(createHelper.createRichTextString("Third Column"));

    // Write the output to a file
    FileOutputStream fileOut;
    try {
        fileOut = new FileOutputStream("C:\\TestData\\POI\\poi-test.xls");
        wb.write(fileOut);
        fileOut.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    System.out.println("Out of method one!");

}

public void methodTwo() {

    System.out.println("Into method two!");
    InputStream inp;
    try {
        inp = new FileInputStream("C:\\TestData\\POI\\poi-test.xls");
        Workbook wb = WorkbookFactory.create(inp);
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.createRow((short) (sheet.getLastRowNum() + 1));

        Cell c = null;
        CreationHelper createHelper = wb.getCreationHelper();

        c = row.createCell(0);
        c.setCellValue(createHelper.createRichTextString("First Row First value"));

        c = row.createCell(1);
        c.setCellValue(createHelper.createRichTextString("First Row Second value"));

        c = row.createCell(2);
        c.setCellValue(createHelper.createRichTextString("First Row Third value"));

        FileOutputStream fileOut = new FileOutputStream("C:\\TestData\\POI\\poi-test.xls");
        wb.write(fileOut);
        fileOut.close();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (InvalidFormatException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }


    System.out.println("Out of method two!");
}

public void methodThree() {

    System.out.println("Into method three!");
    InputStream inp;
    try {
        inp = new FileInputStream("C:\\TestData\\POI\\poi-test.xls");
        Workbook wb = WorkbookFactory.create(inp);
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.createRow((short) (sheet.getLastRowNum() + 1));

        Cell c = null;
        CreationHelper createHelper = wb.getCreationHelper();

        c = row.createCell(0);
        c.setCellValue(createHelper.createRichTextString("Second Row First value"));

        c = row.createCell(1);
        c.setCellValue(createHelper.createRichTextString("Second Row Second value"));

        c = row.createCell(2);
        c.setCellValue(createHelper.createRichTextString("Second Row Third value"));

        FileOutputStream fileOut = new FileOutputStream("C:\\TestData\\POI\\poi-test.xls");
        wb.write(fileOut);
        fileOut.close();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (InvalidFormatException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    System.out.println("Out of method three!");

}

public void methodFour() {

    System.out.println("Into method four!");
    File file = new File("C:\\TestData\\POI\\poi-test.xls");
    // file.deleteOnExit();
    System.out.println("Out of method four!");

}

public static void main(final String[] args) {

    PoiWriteExcelFile myObj = new PoiWriteExcelFile();
    myObj.methodOne();
    myObj.methodTwo();
    myObj.methodThree();
    myObj.methodFour();

}

}
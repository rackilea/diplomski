package test;  

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class PoiWriteExcelFile {

public static void main(String[] args) {
    try {
        FileOutputStream fileOut = new FileOutputStream("poi-test.xls");
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet worksheet = workbook.createSheet("POI Worksheet");

        // index from 0,0... cell A1 is cell(0,0)
        HSSFRow row1 = worksheet.createRow((short) 0);

        HSSFCell cellA1 = row1.createCell((short) 0);
        cellA1.setCellValue("Hello");
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFillForegroundColor(HSSFColor.GOLD.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellA1.setCellStyle(cellStyle);

        HSSFCell cellB1 = row1.createCell((short) 1);
        cellB1.setCellValue("Goodbye");
        cellStyle = workbook.createCellStyle();
        cellStyle.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellB1.setCellStyle(cellStyle);

        HSSFCell cellC1 = row1.createCell((short) 2);
        cellC1.setCellValue(true);

        HSSFCell cellD1 = row1.createCell((short) 3);
        cellD1.setCellValue(new Date());
        cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(HSSFDataFormat
                .getBuiltinFormat("m/d/yy h:mm"));
        cellD1.setCellStyle(cellStyle);

        workbook.write(fileOut);
        fileOut.flush();
        fileOut.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

  }
}
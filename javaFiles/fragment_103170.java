import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;


public class Main {

    public Main() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args)  throws IOException {
        FileInputStream file = null;
        HSSFWorkbook wb = null;
        FileOutputStream out = null;
    try{
         file = new FileInputStream(new File("E:\\products.xls"));

         wb = new HSSFWorkbook(file);
        HSSFSheet sheet = wb.getSheetAt(0);

        for(int i=1; i<= sheet.getLastRowNum(); i++){
            Row row = sheet.getRow(i);
            deleteRow(sheet, row);
        }

         out = new FileOutputStream(new File("E:\\products.xls"));
        wb.write(out);


    }
    catch(Exception e){}
    finally{
        if(file!=null)
        file.close();
        if(out!=null)
        out.close();
        if(wb!=null)
        wb.close();
    }

    }
        public static void deleteRow(HSSFSheet sheet, Row row) {
            int lastRowNum = sheet.getLastRowNum();
            int rowIndex = row.getRowNum();
            if(rowIndex >= 0 && rowIndex < lastRowNum){
                sheet.shiftRows(rowIndex + 1, lastRowNum, -1);
            }
            if(rowIndex == lastRowNum){
                Row removingRow = sheet.getRow(rowIndex);
                if(removingRow != null){
                    sheet.removeRow(removingRow);
                     System.out.println("Deleting.... ");
                }    
        }
    }

}
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;
import java.io.*;
import org.apache.poi.hssf.usermodel.*;


public class XLSExporter implements Exporter {

    /**
     * Constructor for XLSExporter
     */
    public XLSExporter(){
    }


    public void exportFile( File f, List o ) throws IOException{

        HSSFWorkbook wb = new HSSFWorkbook();
        FileOutputStream fileOut = new FileOutputStream(f);

        HSSFSheet sheet = wb.createSheet();


        ListIterator it = o.listIterator();

        //Construct the headings
        HSSFRow headingsRow  = sheet.createRow((short)0); 


        //Heading format
        HSSFFont headingFont = wb.createFont();
        headingFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        HSSFCellStyle headingStyle = wb.createCellStyle();
        headingStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        headingStyle.setFont(headingFont);


        HSSFCell headingA = headingsRow.createCell((short)0);
        headingA.setCellValue("Heading");
        headingA.setCellStyle(headingStyle);




        int i = 1;
        // Iterate over the rows
        while(it.hasNext()){


            //Create the row
            HSSFRow row  = sheet.createRow((short)i); 

            //Write data
            HSSFCell cellRunway = row.createCell((short)0);
            cellRunway.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            cellRunway.setCellValue("Whateva");             
            cellRunway.setCellStyle(standardStyle);



            i++;
        }

        //Set the column widths where needed
        sheet.setColumnWidth((short)1, (short)4000); 


        wb.write(fileOut); // Write the workbook
        fileOut.close();
    }

}
import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import  org.apache.poi.hssf.usermodel.HSSFRow;
import  org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.IOException;   
import org.apache.commons.io.FileSystemUtils; 
import java.io.*;
import java.io.File;
import java.io.IOException;   
import org.apache.commons.io.FileSystemUtils;    
import java.io.File;
import java.util.ArrayList;

public class DiskSpace 
{
    public static void main(String[] args) 
    {  try{ String filename="/home/likewise-open/EZDI-DOMAIN/cshah/Desktop/NewExamle.xls" ;
    HSSFWorkbook workbook=new HSSFWorkbook();
    HSSFSheet sheet =  workbook.createSheet("FirstSheet");  
        ArrayList alldisk=null;
        alldisk=new ArrayList();
        alldisk.add("/home/likewise-open/EZDI-DOMAIN/cshah/Desktop");


        File drive=null;
        long capacity=0,freespace=0, usedspace=0; 
        for(int i=0;i<alldisk.size();i++)
        {
           drive = new File(alldisk.get(i).toString());
           capacity = drive.getTotalSpace(); 
           freespace = drive.getFreeSpace(); 
           usedspace = capacity - freespace;
           HSSFRow rowhead= sheet.createRow((short)i);
            //rowhead.getCell(1).setCellValue(capacity);
            rowhead.createCell(0).setCellValue(capacity);
            rowhead.createCell(1).setCellValue(freespace);
            rowhead.createCell(2).setCellValue(usedspace);

        }
        FileOutputStream fileOut =  new FileOutputStream(filename);
        workbook.write(fileOut);
        fileOut.close();} catch ( Exception ex ) {
            ex.printStackTrace();

        }
           }}
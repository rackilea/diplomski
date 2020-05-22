package com.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelRead {

     public static void main(String[] args) throws IOException{

            String fileName = "D:\\FileDownload\\example.xls";
            String cellContent = "Mainly used for mobile";
            int rownr=0;
            int colnr = 0; //column from which you need data to store in array list

            InputStream input = new FileInputStream(fileName);

            HSSFWorkbook wb = new HSSFWorkbook(input);
            HSSFSheet sheet = wb.getSheetAt(0);
            List MobileSeries=new ArrayList();
            MobileSeries = findRow(sheet, cellContent);

            if(MobileSeries !=null){
                for(Iterator iter=MobileSeries.iterator();iter.hasNext();){
                    System.out.println(iter.next());


            }
            }
            //output(sheet, rownr, colnr);

            finish();
        }

        private static void output(HSSFSheet sheet, int rownr, int colnr) {
            /*
             * This method displays the total value of the month
             */

            HSSFRow row = sheet.getRow(rownr);
            HSSFCell cell = row.getCell(colnr);

                    System.out.println("Your total is: " + cell);           
        }

        private static List findRow(HSSFSheet sheet, String cellContent) {
            List MobileSeries=new ArrayList();
            for (Row row : sheet) {
                for (Cell cell : row) {
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                        if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
                            //System.out.println("Row numbers are"+row.getRowNum());
                            int rownumber=row.getRowNum();
                            //return row.getRowNum();
                            HSSFRow row1 = sheet.getRow(rownumber);
                            HSSFCell cell1 = row1.getCell(0);
                            MobileSeries.add(cell1);
                        }
                    }
                }
            }    
            return MobileSeries;


        }

        private static void finish() {

            System.exit(0);
        }
    }
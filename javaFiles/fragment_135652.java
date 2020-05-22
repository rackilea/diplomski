package additives;
import org.apache.poi.ss.usermodel.*; 
import org.apache.poi.xssf.usermodel.*;

import java.util.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.*;
public class StackOverflow {

    public static Workbook readWorkbook(){

        Workbook wb=null;
        try {
            wb = WorkbookFactory.create(new File("stackOverflow.xlsx"));
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }

    public static void writeToSheet(List<String> name, List<Double> salary, int sheetCounter, List<Sheet> outputSheets){


        for(int i=0;i<salary.size();i++){

            Row row=outputSheets.get(sheetCounter).createRow(i);

            Cell nameCell=row.createCell(0);
            nameCell.setCellValue(name.get(i));

            Cell salaryCell=row.createCell(1);
            salaryCell.setCellValue(salary.get(i));
        }
    }

    public static void writeToWorkbook(Workbook wb){

        try{
            FileOutputStream out=new FileOutputStream("new StackOverflow.xlsx");
            wb.write(out);
            out.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        Workbook inputWb=readWorkbook();
        Sheet inputWs=inputWb.getSheet("sheet1");

        List<String> name=new ArrayList<>();
        List<Double> salary=new ArrayList<>();

        Workbook outputWb=new XSSFWorkbook();
        List<Sheet> outputSheets=new ArrayList<>();

        int rowIndex=inputWs.getLastRowNum()+1;
        int sheetCounter=0;

        for(int i=1; i<rowIndex-1; i++){
            Row outerRow=inputWs.getRow(i);
            Row innerRow=null; 
            Cell outerCell=outerRow.getCell(0);
            Cell innerCell=null;

            int j=0;
            for(j=i+1;j<rowIndex;j++){

                innerRow=inputWs.getRow(j);
                innerCell=innerRow.getCell(0);

                if(outerCell.getStringCellValue().equals(innerCell.getStringCellValue())){
                    name.add(innerRow.getCell(0).getStringCellValue());
                    salary.add(innerRow.getCell(1).getNumericCellValue());
                }


                if(!outerCell.getStringCellValue().equals(innerCell.getStringCellValue())){

                    break;
                }


            }

            name.add(outerRow.getCell(0).getStringCellValue());
            salary.add(outerRow.getCell(1).getNumericCellValue());
            i=j;
            outputSheets.add(outputWb.createSheet("sheet"+sheetCounter));
            writeToSheet(name,salary,sheetCounter, outputSheets);
            sheetCounter++;
            name.clear();
            salary.clear();

            Row tempRow=inputWs.getRow(i);
            try{
                name.add(tempRow.getCell(0).getStringCellValue());
                salary.add(tempRow.getCell(1).getNumericCellValue());
            }catch(Exception e){
                continue;
            }
        }
        writeToWorkbook(outputWb);
    }
}
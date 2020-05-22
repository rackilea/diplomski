package com.industries.seanimus;  

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  

public class ReportSplitter {

    private final String fileName;
    private final int maxRows;

    public ReportSplitter(String fileName, final int maxRows) {

        ZipSecureFile.setMinInflateRatio(0);

        this.fileName = fileName;
        this.maxRows = maxRows;

        try {
            /* Read in the original Excel file. */
            OPCPackage pkg = OPCPackage.open(new File(fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(pkg);
            XSSFSheet sheet = workbook.getSheetAt(0);

            /* Only split if there are more rows than the desired amount. */
            if (sheet.getPhysicalNumberOfRows() >= maxRows) {
                List<SXSSFWorkbook> wbs = splitWorkbook(workbook);
                writeWorkBooks(wbs);
            }
            pkg.close();
        }
        catch (EncryptedDocumentException | IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    private List<SXSSFWorkbook> splitWorkbook(XSSFWorkbook workbook) {

        List<SXSSFWorkbook> workbooks = new ArrayList<SXSSFWorkbook>();

        SXSSFWorkbook wb = new SXSSFWorkbook();
        SXSSFSheet sh = wb.createSheet();

        SXSSFRow newRow;
        SXSSFCell newCell;

        int rowCount = 0;
        int colCount = 0;

        XSSFSheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            newRow = sh.createRow(rowCount++);

            /* Time to create a new workbook? */
            if (rowCount == maxRows) {
                workbooks.add(wb);
                wb = new SXSSFWorkbook();
                sh = wb.createSheet();
                rowCount = 0;
            }

            for (Cell cell : row) {
                newCell = newRow.createCell(colCount++);
                newCell = setValue(newCell, cell);

                CellStyle newStyle = wb.createCellStyle();
                newStyle.cloneStyleFrom(cell.getCellStyle());
                newCell.setCellStyle(newStyle);
            }
            colCount = 0;
        }

        /* Only add the last workbook if it has content */
        if (wb.getSheetAt(0).getPhysicalNumberOfRows() > 0) {
            workbooks.add(wb);
        }
        return workbooks;
    }

    /*
     * Grabbing cell contents can be tricky. We first need to determine what
     * type of cell it is.
     */
    private SXSSFCell setValue(SXSSFCell newCell, Cell cell) {
        switch (cell.getCellType()) {
        case Cell.CELL_TYPE_STRING: 
            newCell.setCellValue(cell.getRichStringCellValue().getString());
            break;
        case Cell.CELL_TYPE_NUMERIC:
            if (DateUtil.isCellDateFormatted(cell)) {
                newCell.setCellValue(cell.getDateCellValue());
            } else {
                newCell.setCellValue(cell.getNumericCellValue());
            }
            break;
        case Cell.CELL_TYPE_BOOLEAN:
            newCell.setCellValue(cell.getBooleanCellValue());
            break;
        case Cell.CELL_TYPE_FORMULA:
            newCell.setCellFormula(cell.getCellFormula());
            break;
        default:
            System.out.println("Could not determine cell type");
        }
        return newCell;
    }

    /* Write all the workbooks to disk. */
    private void writeWorkBooks(List<SXSSFWorkbook> wbs) {
        FileOutputStream out;
        try {
            for (int i = 0; i < wbs.size(); i++) {
                String newFileName = fileName.substring(0, fileName.length() - 5);
                out = new FileOutputStream(new File(newFileName + "_" + (i + 1) + ".xlsx"));
                wbs.get(i).write(out);
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        /* This will create a new workbook every 1000 rows. */
        new ReportSplitter("Data.xlsx", 1000);
    }

}
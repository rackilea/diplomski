/**********************************************************************************************************************
 * Import definitions
 *********************************************************************************************************************/
import java.awt.Desktop;
import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.*;
import org.apache.poi.xssf.streaming.*;
import org.apache.poi.xssf.usermodel.*;

import org.apache.poi.ss.util.ImageUtils;

/**********************************************************************************************************************
 * This class implements a Minimal, Complete and Verifiable example for the problem of the maximum dy value for the
 * {@link XSSFClientAnchor}.
 *********************************************************************************************************************/
public class TestPictureOffset
{
  /********************************************************************************************************************
   * This constants represents the name of the file with the picture to import within the sheet.
   *******************************************************************************************************************/
  private static final String FILENAME_PICTURE = "./excel.png";

  /********************************************************************************************************************
   * These constants represents the width and height of the big cell within the sheet.
   *******************************************************************************************************************/
  // Don't do that. Instead do the same as apache poi does and use
  // sheet.getColumnWidthInPixels and
  // ImageUtils.getRowHeightInPixels to calculate width and height

  private static final short BIG_CELL_COLUMN_WIDTH_IN_PIXELS = 317;
  private static final short BIG_CELL_ROW_HEIGHT_IN_PIXELS = 56;

  /********************************************************************************************************************
   * This constants represents the default height of a cell within the sheet.
   *******************************************************************************************************************/
  private static final short DEFAULT_ROW_HEIGHT_IN_PIXELS = 20;

  /********************************************************************************************************************
   * This method places the specified picture on the sheet.
   *******************************************************************************************************************/
  private static void setPicture(int        picture_index,
                                 Sheet sheet)
  {
    // -----------------
    // Initialize anchor
    // -----------------
    ClientAnchor anchor;
    anchor = sheet.getWorkbook().getCreationHelper().createClientAnchor();
    anchor.setAnchorType(ClientAnchor.AnchorType.MOVE_AND_RESIZE);

    // -----------------------------
    // Set position
    // THIS IS WHERE THE FUN HAPPENS
    // -----------------------------
    anchor.setCol1(1);
    anchor.setRow1(0);
    //anchor.setDx1((int)(0.5 * BIG_CELL_COLUMN_WIDTH_IN_PIXELS * Units.EMU_PER_PIXEL));
    //anchor.setDy1((int)(0.4 * BIG_CELL_ROW_HEIGHT_IN_PIXELS * Units.EMU_PER_PIXEL));
    anchor.setDx1((int)(0.5 * sheet.getColumnWidthInPixels(1) * Units.EMU_PER_PIXEL));
    anchor.setDy1((int)(0.4 * ImageUtils.getRowHeightInPixels(sheet, 0) * Units.EMU_PER_PIXEL));
    anchor.setCol2(anchor.getCol1() + 1);
    anchor.setRow2(anchor.getRow1() + 1);   // Fails if dy1 > 190500
    //anchor.setRow2(anchor.getRow1() + 2); // OK independently from dy1
    anchor.setDx2(0);
    anchor.setDy2(0);

    // ----------------------
    // Show some measurements
    // ----------------------
    System.out.println("Got dy1: " + anchor.getDy1());
    System.out.println("Maximum dy in default cell: " + (DEFAULT_ROW_HEIGHT_IN_PIXELS * Units.EMU_PER_PIXEL));

    // ----------------
    // Draw the picture
    // ----------------
    sheet.createDrawingPatriarch().createPicture(anchor, picture_index);

  } // setPicture

  /********************************************************************************************************************
   * This method runs the application.
   *******************************************************************************************************************/
  private static void run()
    throws Exception
  {
    // ---------------
    // Create workbook
    // ---------------
    SXSSFWorkbook workbook;
    workbook = new SXSSFWorkbook();
    workbook.setCompressTempFiles(true);

    // ------------
    // Create sheet
    // ------------
    SXSSFSheet sheet;
    sheet = workbook.createSheet("TestSheet");
    sheet.trackAllColumnsForAutoSizing();

    // --------------------------
    // Create style with big font
    // --------------------------
    Font          font;
    CellStyle style;
    font = workbook.createFont();
    font.setFontHeightInPoints((short)32);
    style = workbook.createCellStyle();
    style.setFont(font);

    // -------------------
    // Write something big
    // -------------------
    SXSSFRow  row;
    SXSSFCell cell;
    row = sheet.createRow(0);
    cell = row.createCell(1);
    cell.setCellStyle(style);
    cell.setCellValue("Hello everybody");

    // -----------------------
    // Set row heigth according to the fonts height
    // -----------------------
    row.setHeightInPoints(workbook.getFontAt(style.getFontIndex()).getFontHeightInPoints()*1.275f);

    // -----------------------
    // Auto resize this column
    // -----------------------
    sheet.autoSizeColumn(1);

    // ------------
    // Load picture
    // ------------
    InputStream input_stream;
    byte[]      bytes;
    input_stream = new FileInputStream(FILENAME_PICTURE);
    bytes = IOUtils.toByteArray(input_stream);
    input_stream.close();

    // ---------------
    // Add to workbook
    // ---------------
    int picture_index;
    picture_index = workbook.addPicture(bytes, SXSSFWorkbook.PICTURE_TYPE_PNG);

    // -------------------------
    // Position picture in sheet
    // -------------------------
    // Workaround for SXSSFSheet which has not the correct row height in
    // private CTTransform2D createXfrm(XSSFClientAnchor anchor) 
    // because of the streaming manner.
    // So set default row height that big:
    sheet.setDefaultRowHeight(sheet.getRow(0).getHeight());
    // set the picture then:
    setPicture(picture_index, sheet);
    // and reset the default row height after that:
    sheet.setDefaultRowHeight((short)(15*20));

    // -------------
    // Save workbook
    // -------------
    File             output_file;
    FileOutputStream output_stream;
    output_file = new File("testxls.xlsx");
    output_stream = new FileOutputStream(output_file);
    workbook.write(output_stream);
    output_stream.close();
    workbook.close();

    workbook.dispose();

    // -------
    // Open it
    // -------
    Desktop.getDesktop().open(output_file);

  } // run

  /********************************************************************************************************************
   *                                                M A I N
   *******************************************************************************************************************/
  public static void main(String[] args)
  {
    try
    {
      run();
    }
    catch (Exception exception)
    {
      exception.printStackTrace();
    }

  } // main

} // class TestPictureOffset
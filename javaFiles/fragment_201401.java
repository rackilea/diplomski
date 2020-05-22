import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.hssf.usermodel.*;

import org.apache.xmlbeans.XmlCursor;

import java.io.*;

class ExcelDeleteImage {

 public static void deleteCTAnchor(XSSFPicture xssfPicture) {
  XSSFDrawing drawing = xssfPicture.getDrawing();
  XmlCursor cursor = xssfPicture.getCTPicture().newCursor();
  cursor.toParent();
  if (cursor.getObject() instanceof org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor) {
   for (int i = 0; i < drawing.getCTDrawing().getTwoCellAnchorList().size(); i++) {
    if (cursor.getObject().equals(drawing.getCTDrawing().getTwoCellAnchorArray(i))) {
     drawing.getCTDrawing().removeTwoCellAnchor(i);
     System.out.println("TwoCellAnchor for picture " + xssfPicture + " was deleted.");
    }
   }
  } else if (cursor.getObject() instanceof org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTOneCellAnchor) {
   for (int i = 0; i < drawing.getCTDrawing().getOneCellAnchorList().size(); i++) {
    if (cursor.getObject().equals(drawing.getCTDrawing().getOneCellAnchorArray(i))) {
     drawing.getCTDrawing().removeOneCellAnchor(i);
     System.out.println("OneCellAnchor for picture " + xssfPicture + " was deleted.");
    }
   }
  } else if (cursor.getObject() instanceof org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAbsoluteAnchor) {
   for (int i = 0; i < drawing.getCTDrawing().getAbsoluteAnchorList().size(); i++) {
    if (cursor.getObject().equals(drawing.getCTDrawing().getAbsoluteAnchorArray(i))) {
     drawing.getCTDrawing().removeAbsoluteAnchor(i);
     System.out.println("AbsoluteAnchor for picture " + xssfPicture + " was deleted.");
    }
   }
  }
 }

 public static void deleteEmbeddedXSSFPicture(XSSFPicture xssfPicture) {
  if (xssfPicture.getCTPicture().getBlipFill() != null) {
   if (xssfPicture.getCTPicture().getBlipFill().getBlip() != null) {
    if (xssfPicture.getCTPicture().getBlipFill().getBlip().getEmbed() != null) {
     String rId = xssfPicture.getCTPicture().getBlipFill().getBlip().getEmbed();
     XSSFDrawing drawing = xssfPicture.getDrawing();
     drawing.getPackagePart().removeRelationship(rId);
     drawing.getPackagePart().getPackage().deletePartRecursive(drawing.getRelationById(rId).getPackagePart().getPartName());
     System.out.println("Picture " + xssfPicture + " was deleted.");
    }
   }
  }
 }

 public static void deleteHSSFShape(HSSFShape shape) {
  HSSFPatriarch drawing = shape.getPatriarch();
  drawing.removeShape(shape);    
  System.out.println("Shape " + shape + " was deleted.");
 }

 public static void main(String[] args) throws Exception {

  String filename = "ExcelWithImages.xlsx";
  //String filename = "ExcelWithImages.xls";

  InputStream inp = new FileInputStream(filename);

  Workbook workbook = WorkbookFactory.create(inp);
  Sheet sheet = workbook.getSheetAt(0);

  Drawing drawing = sheet.getDrawingPatriarch();

  XSSFPicture xssfPictureToDelete = null;
  if (drawing instanceof XSSFDrawing) {
   for (XSSFShape shape : ((XSSFDrawing)drawing).getShapes()) {
    if (shape instanceof XSSFPicture) {
     XSSFPicture xssfPicture = (XSSFPicture)shape;
     String shapename = xssfPicture.getShapeName();
     int row = xssfPicture.getClientAnchor().getRow1();
     int col = xssfPicture.getClientAnchor().getCol1();
     System.out.println("Picture " + "" + " with Shapename: " + shapename + " is located row: " + row + ", col: " + col);

     if ("Image 2".equals(shapename)) xssfPictureToDelete = xssfPicture;

    }
   }
  }
  if  (xssfPictureToDelete != null) deleteEmbeddedXSSFPicture(xssfPictureToDelete);
  if  (xssfPictureToDelete != null) deleteCTAnchor(xssfPictureToDelete);

  HSSFPicture hssfPictureToDelete = null;
  if (drawing instanceof HSSFPatriarch) {
   for (HSSFShape shape : ((HSSFPatriarch)drawing).getChildren()) {
    if (shape instanceof HSSFPicture) {
     HSSFPicture hssfPicture = (HSSFPicture)shape;
     int picIndex = hssfPicture.getPictureIndex();
     String shapename = hssfPicture.getShapeName().trim();
     int row = hssfPicture.getClientAnchor().getRow1();
     int col = hssfPicture.getClientAnchor().getCol1();
     System.out.println("Picture " + picIndex + " with Shapename: " + shapename + " is located row: " + row + ", col: " + col);

     if ("Image 2".equals(shapename)) hssfPictureToDelete = hssfPicture;

    }
   }
  }
  if (hssfPictureToDelete != null) deleteHSSFShape(hssfPictureToDelete);

  FileOutputStream out = new FileOutputStream(filename);
  workbook.write(out);
  out.close();
  workbook.close();
 }
}
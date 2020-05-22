import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.xwpf.usermodel.XWPFTable.XWPFBorderType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.util.EnumMap;

import java.math.BigInteger;

public class CreateWordTableBorders {

 private static EnumMap<XWPFBorderType, STBorder.Enum> xwpfBorderTypeMap;
 static {
  // populate enum map
  xwpfBorderTypeMap = new EnumMap<XWPFBorderType, STBorder.Enum>(XWPFBorderType.class);
  xwpfBorderTypeMap.put(XWPFBorderType.NIL, STBorder.Enum.forInt(STBorder.INT_NIL));
  xwpfBorderTypeMap.put(XWPFBorderType.NONE, STBorder.Enum.forInt(STBorder.INT_NONE));
  xwpfBorderTypeMap.put(XWPFBorderType.SINGLE, STBorder.Enum.forInt(STBorder.INT_SINGLE));
  xwpfBorderTypeMap.put(XWPFBorderType.THICK, STBorder.Enum.forInt(STBorder.INT_THICK));
  xwpfBorderTypeMap.put(XWPFBorderType.DOUBLE, STBorder.Enum.forInt(STBorder.INT_DOUBLE));
  xwpfBorderTypeMap.put(XWPFBorderType.DOTTED, STBorder.Enum.forInt(STBorder.INT_DOTTED));
  xwpfBorderTypeMap.put(XWPFBorderType.DASHED, STBorder.Enum.forInt(STBorder.INT_DASHED));
  xwpfBorderTypeMap.put(XWPFBorderType.DOT_DASH, STBorder.Enum.forInt(STBorder.INT_DOT_DASH));
 }

 private enum BorderPosition {
  TOP, BOTTOM, LEFT, RIGHT
 }

 private static void setTableBorder(BorderPosition position, XWPFTable table, XWPFBorderType type, 
  int size, int space, String rgbColor) {

  CTTblPr tblPr = (table.getCTTbl().getTblPr() != null) ? table.getCTTbl().getTblPr() : table.getCTTbl().addNewTblPr();
  CTTblBorders ctb = tblPr.isSetTblBorders() ? tblPr.getTblBorders() : tblPr.addNewTblBorders();
  CTBorder b = null;
  switch (position) {
   case TOP:
   b = ctb.isSetTop() ? ctb.getTop() : ctb.addNewTop();
   break;
   case BOTTOM:
   b = ctb.isSetBottom() ? ctb.getBottom() : ctb.addNewBottom();
   break;
   case LEFT:
   b = ctb.isSetLeft() ? ctb.getLeft() : ctb.addNewLeft();
   break;
   case RIGHT:
   b = ctb.isSetRight() ? ctb.getRight() : ctb.addNewRight();
   break;
  }
  b.setVal(xwpfBorderTypeMap.get(type));
  b.setSz(BigInteger.valueOf(size));
  b.setSpace(BigInteger.valueOf(space));
  b.setColor(rgbColor);
 }

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument();

  XWPFParagraph paragraph = document.createParagraph();

  XWPFTable table = document.createTable(3, 3);
  //create CTTblGrid for this table with widths of the 3 columns. 
  //necessary for Libreoffice/Openoffice to accept the column widths.
  //values are in unit twentieths of a point (1/1440 of an inch)
  //first column = 1 inches width
  table.getCTTbl().addNewTblGrid().addNewGridCol().setW(BigInteger.valueOf(1*1440));
  //other columns (2 in this case) also each 1 inches width
  for (int col = 1 ; col < 3; col++) {
   table.getCTTbl().getTblGrid().addNewGridCol().setW(BigInteger.valueOf(1*1440));
  }

  for (int col = 0; col < 3; col++) {
   table.getRow(0).getCell(col).setText("Column " + (col+1));
  }

  setTableBorder(BorderPosition.TOP, table, XWPFBorderType.SINGLE, 24/*unit 1/8 pt*/, 0, "0000FF");
  setTableBorder(BorderPosition.BOTTOM, table, XWPFBorderType.SINGLE, 24/*unit 1/8 pt*/, 0, "0000FF");
  setTableBorder(BorderPosition.LEFT, table, XWPFBorderType.SINGLE, 24/*unit 1/8 pt*/, 0, "0000FF");
  setTableBorder(BorderPosition.RIGHT, table, XWPFBorderType.SINGLE, 24/*unit 1/8 pt*/, 0, "0000FF");

  table.setInsideHBorder(XWPFTable.XWPFBorderType.DASHED, 8/*unit 1/8 pt*/, 0, "000000");
  table.setInsideVBorder(XWPFTable.XWPFBorderType.DASHED, 8/*unit 1/8 pt*/, 0, "000000");

  paragraph = document.createParagraph();

  document.write(new FileOutputStream("CreateWordTableBorders.docx"));
  document.close();

 }
}
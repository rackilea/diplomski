import java.awt.font.FontRenderContext;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.text.AttributedString;
import java.awt.geom.Rectangle2D;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.SheetUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePoiGetStringWidth {

 public static void main(String args[]) throws Exception {

  String testString = "Lorem ipsum semit dolor";
  String fontName = "Calibri";
  short fontSize = 24;
  boolean italic = true;
  boolean bold = false;

  Workbook workbook = new XSSFWorkbook();
  Font font = workbook.createFont();
  font.setFontHeightInPoints(fontSize);
  font.setFontName(fontName);
  font.setItalic(italic);
  font.setBold(bold);
  CellStyle style = workbook.createCellStyle();
  style.setFont(font);

  AttributedString attributedString = new AttributedString(testString);
  attributedString.addAttribute(TextAttribute.FAMILY, font.getFontName(), 0, testString.length());
  attributedString.addAttribute(TextAttribute.SIZE, (float)font.getFontHeightInPoints());
  if (font.getBold()) attributedString.addAttribute(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD,  0, testString.length());
  if (font.getItalic()) attributedString.addAttribute(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE,  0, testString.length());

  FontRenderContext fontRenderContext = new FontRenderContext(null, true, true);

  TextLayout layout = new TextLayout(attributedString.getIterator(), fontRenderContext);
  Rectangle2D bounds = layout.getBounds();
  double frameWidth = bounds.getX() + bounds.getWidth();

System.out.println(frameWidth);

  Sheet sheet = workbook.createSheet();
  Row row = sheet.createRow(2);
  Cell cell = row.createCell(2);
  cell.setCellValue(testString);
  cell.setCellStyle(style);

  int defaultCharWidth = SheetUtil.getDefaultCharWidth(workbook);
  sheet.setColumnWidth(2, (int)Math.round(frameWidth / defaultCharWidth * 256));

  try (java.io.FileOutputStream out = new java.io.FileOutputStream("Excel.xlsx")) {
   workbook.write(out);
  }

  workbook.close();

 }
}
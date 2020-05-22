private static Map<String, CellStyle> styling(Workbook wb)
{
  Map<String, CellStyle> styles = new HashMap<>();
  XSSFCellStyle style;

  Font font1 = wb.createFont();
  font1.setBold(true);
  style = (XSSFCellStyle) createBorderedStyle(wb);
  style.setAlignment(HorizontalAlignment.RIGHT);
  style.setFont(font1);
  style.setFillForegroundColor(new XSSFColor(new java.awt.Color(128, 0, 128), new DefaultIndexedColorMap()));
  style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
  styles.put("cell_g", style);

  return styles; 
}
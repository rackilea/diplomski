Color sColor = new Color(200, 0, 0);
XSSFColor userColor = new XSSFColor(sColor);

CellStyle style = wb.createCellStyle();
XSSFFont font = wb.createFont();
font.setColor(userColor);
style.setFont(font);
cell.setCellStyle(style);
DataFormatter dataFormatter = new DataFormatter();

int defaultCharWidth = SheetUtil.getDefaultCharWidth(workbook);

double cellValueWidth = SheetUtil.getCellWidth(cell, defaultCharWidth, dataFormatter, false);
int neededColunmnWidth = (int)cellValueWidth*256;
int columnWidth = sheet.getColumnWidth(c);

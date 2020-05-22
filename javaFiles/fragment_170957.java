WritableCellFormat newFormat = null;
WritableSheet sheet = workbook.getSheet(0);
Cell readCell = sheet.getCell(column, row); //read format from another cell(if you want to copy its existing properties otherwise you can ignore).
WritableCellFormat cellFormatObj = new WritableCellFormat(
                    noBoldFont);
CellFormat readFormat = readCell.getCellFormat() == null ? cellFormatObj
                    : readCell.getCellFormat();
newFormat = new WritableCellFormat(readFormat);
newFormat.setBackground(Colour.WHITE);
newFormat.setBorder(jxl.format.Border.BOTTOM,jxl.format.BorderLineStyle.THIN);
newFormat.setAlignment(Alignment.CENTRE);
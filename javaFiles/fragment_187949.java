if(cell.getCellType() == HSSFCell.CELL_TYPE_FORMULA) {
 switch(cell.getCachedFormulaResultType()) {
  case HSSFCell.CELL_TYPE_STRING:
     HSSFRichTextString str = cell.getRichStringCellValue();
     if(str != null && str.length() > 0) {
        text.append(str.toString());
     }
     break;
  case HSSFCell.CELL_TYPE_NUMERIC:
     HSSFCellStyle style = cell.getCellStyle();
     if(style == null) {
        text.append( cell.getNumericCellValue() );
     } else {
        text.append(
              _formatter.formatRawCellContents(
                    cell.getNumericCellValue(),
                    style.getDataFormat(),
                    style.getDataFormatString()
              )
        );
     }
     break;
  case HSSFCell.CELL_TYPE_BOOLEAN:
     text.append(cell.getBooleanCellValue());
     break;
  case HSSFCell.CELL_TYPE_ERROR:
     text.append(ErrorEval.getText(cell.getErrorCellValue()));
     break;
 }
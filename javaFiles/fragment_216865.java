XSSFRichTextString val = cell4.getRichStringCellValue(); 
XSSFFont f = val.getFontAtIndex(0);
if (f == null) {
   // Default cell font applies
   XSSFCellStyle style = cell4.getCellStyle().getFont();
}
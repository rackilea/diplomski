HSSFFont font = wb.createFont();
font.setItalic(true);
font.setUnderline(HSSFFont.U_DOUBLE);
HSSFRichTextString string = new HSSFRichTextString("Woo!!!");
string.applyFont(2,5,font);
textbox.setString(string );
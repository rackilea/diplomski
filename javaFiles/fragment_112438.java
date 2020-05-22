XSSFWorkbook wb = new XSSFWorkbook();
XSSFHyperlink link = wb.getCreationHelper().createHyperlink(HyperlinkType.URL);
XSSFCellStyle hlinkstyle = wb.createCellStyle();
XSSFFont hlinkfont = wb.createFont();
hlinkfont.setUnderline(XSSFFont.U_SINGLE);
hlinkfont.setColor(IndexedColors.BLUE.index);
hlinkstyle.setFont(hlinkfont);
link.setAddress("http://www.google.de/");
Sheet s = wb.createSheet();
Row r = s.createRow(0);
Cell c = r.createCell(0);
c.setHyperlink(link);
c.setCellStyle(hlinkstyle);  //<-- make it look like link
c.setCellValue(link.getAddress());  // <-- important
wb.write(new FileOutputStream(new File("D:\\Test\\hyperlink.xlsx")));
wb.close();
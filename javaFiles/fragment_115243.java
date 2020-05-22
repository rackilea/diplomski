Workbook wb = new HSSFWorkbook();
CreationHelper helper = wb.getCreationHelper();
Sheet sheet = wb.createSheet("new sheet");

List<String> lines = IOUtils.readLines(new StringReader(csv));

    for (int i = 0; i < lines.size(); i++) {
        String str[] = lines.get(i).split(",");
        Row row = sheet.createRow((short) i);
        for (int j = 0; j < str.length; j++) {
             row.createCell(j).setCellValue(helper.createRichTextString(str[j]));

                 }
              }

FileOutputStream fileOut = new FileOutputStream("c:\\someName.xls");
    wb.write(fileOut);
    fileOut.close();
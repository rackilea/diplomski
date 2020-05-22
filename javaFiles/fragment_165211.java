FileOutputStream fout=new FileOutputStream(new File("C:\\Users\\151680\\workspace\\trial.xlsx"));
      XSSFWorkbook wb=new XSSFWorkbook();
      XSSFSheet sh1=wb.createSheet();
      XSSFRow row = sh1.createtRow(0);
      row.createCell(0).setCellValue("abc");
      row.createCell(1).setCellValue("def");
      wb.write(fout);
      fout.close();
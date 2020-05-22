FileInputStream fileIn =null;
 FileOutputStream fileOut = null;
 final Workbook wb; 

      fileIn =new FileInputStream("d:\\excelfiles\\Report.xlsm");
      wb = WorkbookFactory.create(fileIn); //open existing file
      final Sheet sheet = wb.getSheet("Report");//open the existing sheet use wb.createSheet() to create a new one
      row = sheet.getRow(0/*row number*/);
      if (row == null)//if row not exists
          row = sheet.createRow(0);
      cellp = row.getCell(4);
      if (cellp == null)
         cellp = row.createCell(0);
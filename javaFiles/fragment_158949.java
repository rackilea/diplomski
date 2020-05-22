HSSFWorkbook workbook = new HSSFWorkbook();
        String fileName = "excelDoc\\" +(new SimpleDateFormat("dd-MM-yy--hh-mm-ss").format(Calendar.getInstance().getTime()))+ ".xls"; //relative location of file + Time stamp based file name (.xls)
        System.out.println(fileName);       
        FileOutputStream  file1 = new FileOutputStream (new File(fileName));    
        HSSFSheet spreadSheet = workbook.createSheet("Result Document");
        HSSFRow row = spreadSheet.createRow((short) 0);
        HSSFCell cell;
        //Creating rows and filling them with data 
        cell = row.createCell(0);
        cell.setCellValue(new HSSFRichTextString("Test No"));
        cell = row.createCell(1);
        cell.setCellValue(new HSSFRichTextString("Test Result"));
        //Please see below and compare
        file1.close();  //Closing the file       
        FileOutputStream outFile =new FileOutputStream(new File(fileName));  //Creating new file
        workbook.write(outFile);   //printing the data in the new file
        outFile.close();           //closing the new file
        System.out.println("The Result are now printed in the excel sheet");
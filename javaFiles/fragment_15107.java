String filename3 = strTablePathR2 + "Results-2"
        + CommonFunctions.getDateAndHour() + ".xls";

HSSFWorkbook wb1 = new HSSFWorkbook();
HSSFSheet sheet1 = **wb1**.createSheet("new sheet1");

HSSFRow row1 = sheet1.createRow((int)0);
row1.createCell((int)0).setCellValue("HelloWorld1");

FileOutputStream fileOut2 = new FileOutputStream(filename3);
**wb1**.write(fileOut2);
fileOut2.flush();
fileOut2.close();
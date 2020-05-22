// The below code constructs the workbook and returns it
SXSSFWorkbook workBook = getWorkBook(fileName, excelData);
ZipEntry zipEntry = new ZipEntry(fileName );
zos.putNextEntry(zipEntry);
workBook.write(new NonCloseableOutputStream(zos));
zos.closeEntry();
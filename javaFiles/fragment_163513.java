FileOutputStream fileOut = new FileOutputStream(workbookName + ".xlsx");
 workbook.write(fileOut);
 fileOut.close();

 workbook.close();
}
public void generateSheet(String type, List<Product> productList) {
    try {

      XSSFWorkbook workbook;
      File file = new File(type);
      FileOutputStream fos = new FileOutputStream(file);
      workbook = new XSSFWorkbook();

      String sname = "TestSheet";
      String parentName = "STATE";
      String childName1 = "GUJARAT";
      String childName2 = "KARNATAKA";
      String childName3 = "MAHARASHTRA";
      XSSFSheet sheet = workbook.createSheet(sname);

      Row row = null;
      Cell cell = null;
      row = sheet.createRow(9);
      cell = row.createCell(0);
      cell.setCellValue("Gujarat");
      cell = row.createCell(1);
      cell.setCellValue("Karnataka");
      cell = row.createCell(2);
      cell.setCellValue("Maharashtra");

      row = sheet.createRow(10);
      cell = row.createCell(0);
      cell.setCellValue("Ahmedabad");
      cell = row.createCell(1);
      cell.setCellValue("Rajkot");
      cell = row.createCell(2);
      cell.setCellValue("Gandhinagar");
      cell = row.createCell(3);
      cell.setCellValue("Surat");
      cell = row.createCell(4);
      cell.setCellValue("Vapi");

      row = sheet.createRow(11);
      cell = row.createCell(0);
      cell.setCellValue("Bangalore");
      cell = row.createCell(1);
      cell.setCellValue("Hasan");
      cell = row.createCell(2);
      cell.setCellValue("Mysore");
      cell = row.createCell(3);
      cell.setCellValue("Mangalore");

      row = sheet.createRow(12);
      cell = row.createCell(0);
      cell.setCellValue("Mumbai");
      cell = row.createCell(1);
      cell.setCellValue("Pune");
      cell = row.createCell(2);
      cell.setCellValue("Aurangabad");


      // 1. create named range for a single cell using areareference
      Name namedCell1 = sheet.getWorkbook().createName();
      namedCell1.setNameName(parentName);
      String reference1 = sname+"!$A$10:$C$10"; // area reference
      namedCell1.setRefersToFormula(reference1);

      Name namedCell2 = sheet.getWorkbook().createName();
      namedCell2.setNameName(childName1);
      String reference2 = sname+"!$A$11:$E$11"; // area reference
      namedCell2.setRefersToFormula(reference2);

      Name namedCell3 = sheet.getWorkbook().createName();
      namedCell3.setNameName(childName2);
      String reference3 = sname+"!$A$12:$D$12"; // area reference
      namedCell3.setRefersToFormula(reference3);

      Name namedCell4 = sheet.getWorkbook().createName();
      namedCell4.setNameName(childName3);
      String reference4 = sname+"!$A$13:$C$13"; // area reference
      namedCell4.setRefersToFormula(reference4);

      DataValidationHelper helper = null;
      DataValidationConstraint constraint = null;
      DataValidation validation = null;

      helper = sheet.getDataValidationHelper();
      constraint = helper.createFormulaListConstraint(parentName);
      validation = helper.createValidation(constraint, new CellRangeAddressList(0,0,0,0));
      sheet.addValidationData(validation);

      constraint = helper.createFormulaListConstraint("INDIRECT(UPPER($A$1))");
      validation = helper.createValidation(constraint, new CellRangeAddressList(0,0,1,1));
      sheet.addValidationData(validation);

      workbook.write(fos);
      fos.flush();
      fos.close();
      LOGGER.info("Finished processing sheet to download");
    } catch (Exception e) {
      Logger.error("Exception while writing excel", e);
    }
  }
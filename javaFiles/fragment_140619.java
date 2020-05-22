try{
    Map<String, Object> parameters = new HashMap<String, Object>();
    parameters.put("param_name", paramValue);

    ExcelDataSource ds = new ExcelDataSource(JRLoader.getLocationInputStream(excelFilePath));
    String[] columnNames = new String[]{"id", "nom", "iden", "adress", "activity", "compta"};
    ds.setColumnNames(columnNames);
    JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(new File(yourJasperFilePath)), parameters, ds);
    JasperPrintManager.printReport(jasperPrint, false);
   } catch (Exception ex) {
      ex.printStackTrace();

   }
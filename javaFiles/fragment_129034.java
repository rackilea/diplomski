String filename = "C:\\input.xls";
  WorkbookSettings ws = new WorkbookSettings();
  ws.setLocale(new Locale("en", "EN"));
  WritableWorkbook workbook = 
  Workbook.createWorkbook(new File(filename), ws);
  WritableSheet s = workbook.createSheet("Input", 0);
  WritableSheet s1 = workbook.createSheet("Output", 1);
  s1.addCell(new Number(3, 0, 5));
  s1.addCell(new Number(3, 1, 6));
  s1.addCell(new Number(3, 2, 1));
  s1.addCell(new Number(3, 3, 6));
  s1.addCell(new Number(3, 4, 1));
  Formula formula = new Formula(3,5,"AVERAGE(D1:D5)");
  s.addCell(formula);
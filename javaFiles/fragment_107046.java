File file = new File("/somepath/test.xls");
Workbook wb = WorkbookFactory.create(file);
Sheet sheet = wb.getSheetAt(0);
FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();

// suppose your formula is in B3
CellReference cellReference = new CellReference("B3");
Row row = sheet.getRow(cellReference.getRow());
Cell cell = row.getCell(cellReference.getCol()); 

evaluator.evaluateInCell(cell);
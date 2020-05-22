DataValidation getDataValidationFromDataValidationEvaluator (Cell cell) {
 Sheet sheet = cell.getSheet(); 
 Workbook workbook = sheet.getWorkbook();
 WorkbookEvaluatorProvider workbookEvaluatorProvider =
   (WorkbookEvaluatorProvider)workbook.getCreationHelper().createFormulaEvaluator();
 DataValidationEvaluator dataValidationEvaluator = new DataValidationEvaluator(workbook, workbookEvaluatorProvider);
 DataValidation dataValidation = dataValidationEvaluator.getValidationForCell(new CellReference(cell));
 return dataValidation;
}
Map<CellRangeAddress, String[]> dropDownValues = new HashMap<>();

List<ExtendedDataValidations> extendedDataValidationsList = getExtendedDataValidations(sheet);
for (ExtendedDataValidations extendedDataValidations : extendedDataValidationsList)
{
    AreaReference formulaReference = new AreaReference(extendedDataValidations.formula);
    CellReference[] allReferencedCells = formulaReference.getAllReferencedCells();
    FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
    String[] values = new String[allReferencedCells.length];
    for (int j = 0; j < allReferencedCells.length; j++)
    {
        CellReference cellReference = allReferencedCells[j];
        Sheet valueSheet = wb.getSheet(cellReference.getSheetName());
        Cell cell = valueSheet.getRow(cellReference.getRow()).getCell(cellReference.getCol());
        CellValue evaluate = formulaEvaluator.evaluate(cell);
        values[j] = StringUtils.trimToEmpty(StringUtils.removeStart(StringUtils.removeEnd(evaluate.formatAsString(), "\""), "\""));
    }

    String stRef = extendedDataValidations.sqref;
    String[] regions = stRef.split(" ");
    for (String region : regions)
    {
        String[] parts = region.split(":");
        CellReference begin = new CellReference(parts[0]);
        CellReference end = parts.length > 1 ? new CellReference(parts[1]) : begin;
        CellRangeAddress cellRangeAddress = new CellRangeAddress(begin.getRow(), end.getRow(), begin.getCol(), end.getCol());
        dropDownValues.put(cellRangeAddress, values);
    }
}
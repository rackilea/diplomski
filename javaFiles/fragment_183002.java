...

row.createCell(3).setCellValue("foo");
HSSFFormulaEvaluator.evaluateAllFormulaCells(wb);

for (int i = 0; i < 4; i++) {
    sheet.autoSizeColumn(i);
}

...
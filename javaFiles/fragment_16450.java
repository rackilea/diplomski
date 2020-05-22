XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        XSSFFormulaEvaluator evaluator = new XSSFFormulaEvaluator(workbook);
        XSSFCell cellvalue = sheet.createRow(0).createCell(0);
        sheet.getRow(0).createCell(1).setCellValue(2);
        sheet.getRow(0).createCell(2).setCellValue(5);
        cellvalue.setCellFormula("B1+C1");
        if (cellvalue.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {
           evaluator.evaluateFormulaCell(cellvalue);
        }
        System.out.println(cellvalue.getNumericCellValue());
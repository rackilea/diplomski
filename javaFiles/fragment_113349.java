//data sheet
    XSSFSheet data = wb.getSheet("DATA SHEET");
    // sheet you want pivot table in
    XSSFSheet sheet = wb.createSheet("PIVOT SHEET");

    CellReference cr = new CellReference("A1");
    CellReference c1 = new CellReference(0, 0);
    CellReference c2 = new CellReference(data.getPhysicalNumberOfRows() - 1, data.getRow(0).getLastCellNum() - 1);
    //source data
    AreaReference ar = new AreaReference(c1, c2);
    XSSFPivotTable pivotTable = sheet.createPivotTable(ar, cr, data);
    //add row labels and other stuff to pivot table
    pivotTable.addRowLabel(10);
    pivotTable.addRowLabel(11);
    pivotTable.addRowLabel(1);
    pivotTable.addColumnLabel(DataConsolidateFunction.COUNT, 0);
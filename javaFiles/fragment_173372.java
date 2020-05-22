//... get or create pivotTable

//Use first column as row label
    pivotTable.addRowLabel(0);
// 1. Add Formula to cache
    addFormulaToCache(pivotTable);
// 2. Add PivotField for Formula column
    addPivotFieldForNewColumn(pivotTable);
// 3. Add all column labels before our function..
    pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 1);
    //Set the third column as filter
    pivotTable.addColumnLabel(DataConsolidateFunction.AVERAGE, 2);
// 4. Add formula column
    addFormulaColumn(pivotTable);
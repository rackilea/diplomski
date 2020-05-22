private static void addFormulaToCache(XSSFPivotTable pivotTable) {
    CTCacheFields ctCacheFields = pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields();
    CTCacheField ctCacheField = ctCacheFields.addNewCacheField();
    ctCacheField.setName("Field1"); // Any field name
    ctCacheField.setFormula("'Ended' / 'Generated' * 100");
    ctCacheField.setDatabaseField(false);
    ctCacheField.setNumFmtId(0);
    ctCacheFields.setCount(ctCacheFields.sizeOfCacheFieldArray()); //!!! update count of fields directly
}

private static void addPivotFieldForNewColumn(XSSFPivotTable pivotTable) {
    CTPivotField pivotField = pivotTable.getCTPivotTableDefinition().getPivotFields().addNewPivotField();
    pivotField.setDataField(true);
    pivotField.setDragToCol(false);
    pivotField.setDragToPage(false);
    pivotField.setDragToRow(false);
    pivotField.setShowAll(false);
    pivotField.setDefaultSubtotal(false);
}

private static void addFormulaColumn(XSSFPivotTable pivotTable) {
    CTDataFields dataFields;
    if(pivotTable.getCTPivotTableDefinition().getDataFields() != null) {
        dataFields = pivotTable.getCTPivotTableDefinition().getDataFields();
    } else {
        // can be null if we have not added any column labels yet
        dataFields = pivotTable.getCTPivotTableDefinition().addNewDataFields();
    }
    CTDataField dataField = dataFields.addNewDataField();
    dataField.setName("Avg Pct Processed");
    // set index of cached field with formula - it is the last one!!!
    dataField.setFld(pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields().getCount()-1);
    dataField.setBaseItem(0);
    dataField.setBaseField(0);
}
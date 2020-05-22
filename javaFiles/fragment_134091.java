public static void addColumLabels(XSSFPivotTable pivotTable, int columnIndex) {
    AreaReference pivotArea = getPivotArea(pivotTable);
    int lastColIndex = pivotArea.getLastCell().getCol() - pivotArea.getFirstCell().getCol();

    if (columnIndex > lastColIndex && columnIndex < 0) {
        throw new IndexOutOfBoundsException();
    }

    CTPivotFields pivotFields = pivotTable.getCTPivotTableDefinition().getPivotFields();

    CTPivotField pivotField = CTPivotField.Factory.newInstance();
    CTItems items = pivotField.addNewItems();

    pivotField.setAxis(STAxis.AXIS_COL);
    pivotField.setShowAll(false);
    for (int i = 0; i <= lastColIndex; i++) {
        items.addNewItem().setT(STItemType.DEFAULT);
    }
    items.setCount(items.sizeOfItemArray());
    pivotFields.setPivotFieldArray(columnIndex, pivotField);

    // colfield should be added for the second one.
    CTColFields colFields;
    if (pivotTable.getCTPivotTableDefinition().getColFields() != null) {
        colFields = pivotTable.getCTPivotTableDefinition().getColFields();
    } else {
        colFields = pivotTable.getCTPivotTableDefinition().addNewColFields();
    }
    colFields.addNewField().setX(columnIndex);
    colFields.setCount(colFields.sizeOfFieldArray());
}
...
   // at least one field in colFields is needed if there are multiple data fields
   CTColFields colFields;
   if(pivotTable.getCTPivotTableDefinition().getColFields() != null) {
    colFields = pivotTable.getCTPivotTableDefinition().getColFields();
   } else {
    colFields = pivotTable.getCTPivotTableDefinition().addNewColFields();
   }
   CTField field;
   if (colFields.getFieldList().size() == 0) {
    field = colFields.addNewField();
    field.setX(-2);
   }
...
XPropertySet xPropertySet = UnoRuntime.queryInterface(
    XPropertySet.class, cell);
XPropertySet xValidPropSet = UnoRuntime.queryInterface(
    XPropertySet.class, xPropertySet.getPropertyValue("Validation"));
xValidPropSet.setPropertyValue("Type", ValidationType.LIST);
xValidPropSet.setPropertyValue("ShowList", (short) 1);
xValidPropSet.setPropertyValue("IgnoreBlankCells", (Boolean) true); 
XSheetCondition xCondition = (XSheetCondition)
    UnoRuntime.queryInterface(XSheetCondition.class, xValidPropSet);
xCondition.setOperator(ConditionOperator.EQUAL);
xCondition.setFormula1("\"1\";\"2\";\"3\"");
xPropertySet.setPropertyValue("Validation", xValidPropSet);
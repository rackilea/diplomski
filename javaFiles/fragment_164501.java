...
 static CTDxf createDxf(boolean fontBold, byte[] fontRGB, byte[] fillRGB) {
  CTDxf dxf = CTDxf.Factory.newInstance();
  CTFont font = dxf.addNewFont();
  if (fontBold) font.addNewB();
  if (fontRGB != null) font.addNewColor().setRgb(fontRGB);
  if (fillRGB != null) {
   CTFill fill = dxf.addNewFill();
   fill.addNewPatternFill().addNewBgColor().setRgb(fillRGB);
  }
  return dxf;
 }

 static void createPivotTableStyle(StylesTable stylesTable, String styleName, Map<STTableStyleType.Enum, CTDxf> typeStyles) {

  // get or create table styles
  CTTableStyles tableStyles = stylesTable.getCTStylesheet().getTableStyles();
  if (tableStyles == null) tableStyles = stylesTable.getCTStylesheet().addNewTableStyles();

  // add table style named as styleName
  CTTableStyle tableStyle = tableStyles.addNewTableStyle();
  tableStyle.setName(styleName);

  // set TableStyleType styles: TableStyleType -> dxf
  for (Map.Entry<STTableStyleType.Enum, CTDxf> entry : typeStyles.entrySet()) {
    STTableStyleType.Enum type = entry.getKey();
    CTDxf typeDxf = entry.getValue();
    int dxfId = stylesTable.putDxf(typeDxf);
    CTTableStyleElement tableStyleElement = tableStyle.addNewTableStyleElement();
    tableStyleElement.setDxfId(dxfId-1);
    tableStyleElement.setType(type);
  }
 }
...
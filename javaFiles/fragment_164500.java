...
  // create a new custom pivot table style
  // create dxf for each needed table style type
  STTableStyleType.Enum headerRow = STTableStyleType.HEADER_ROW;
  CTDxf headerRowDxf = createDxf(true, new byte[] {(byte)255, (byte)255, (byte)255}, new byte[] {(byte)0, (byte)80, (byte)0});
  STTableStyleType.Enum totalRow = STTableStyleType.TOTAL_ROW;
  CTDxf totalRowDxf = createDxf(true, new byte[] {(byte)255, (byte)255, (byte)255}, new byte[] {(byte)0, (byte)80, (byte)0});
  STTableStyleType.Enum firstRowSubheading = STTableStyleType.FIRST_ROW_SUBHEADING;
  CTDxf firstRowSubheadingDxf = createDxf(true, null, null);
  STTableStyleType.Enum secondRowSubheading = STTableStyleType.SECOND_ROW_SUBHEADING;
  CTDxf secondRowSubheadingDxf = createDxf(true, null, null);
  // map table style types to dxf
  Map<STTableStyleType.Enum, CTDxf> typeStyles = new HashMap<STTableStyleType.Enum, CTDxf>();
  typeStyles.put(headerRow, headerRowDxf);
  typeStyles.put(totalRow, totalRowDxf);
  typeStyles.put(firstRowSubheading, firstRowSubheadingDxf);
  typeStyles.put(secondRowSubheading, secondRowSubheadingDxf);
  // 
  createPivotTableStyle(((XSSFWorkbook)wb).getStylesSource(), "CustomPivotStyle1", typeStyles);
  pivotTable.getCTPivotTableDefinition().getPivotTableStyleInfo().setName("CustomPivotStyle1");
...
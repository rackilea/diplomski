SpreadsheetDocument ods = SpreadsheetDocument.newSpreadsheetDocument();
    Table table = Table.newTable(ods, 4000, 20, 0, 0);
    table.setTableName("foo");
    //create style
    OdfOfficeAutomaticStyles astyles = ods.getContentDom().getOrCreateAutomaticStyles();
    StyleStyleElement ele = astyles.newStyleStyleElement(OdfStyleFamily.TableCell.getName(), "myss");
    StyleTableCellPropertiesElement styleTableCellPropertiesElement = ele.newStyleTableCellPropertiesElement();
    styleTableCellPropertiesElement.setFoBackgroundColorAttribute("#A5A5A5");
    styleTableCellPropertiesElement.setFoBorderAttribute("1.0pt solid #000000");
    ele.newStyleParagraphPropertiesElement().setFoTextAlignAttribute(HorizontalAlignmentType.CENTER.toString());
    StyleTextPropertiesElement styleTextPropertiesElement = ele.newStyleTextPropertiesElement(null);
    styleTextPropertiesElement.setStyleFontNameAttribute("Arial");
    styleTextPropertiesElement.setFoFontSizeAttribute("7.0pt");
    styleTextPropertiesElement.setFoColorAttribute(Color.BLACK.toString());
    styleTextPropertiesElement.setFoFontWeightAttribute("bold");

    List<Row> rows = table.getRowList();
    for (Row r : rows) {
        for (int a = 0; a < 10; a++) {
            Cell cell = r.getCellByIndex(a);
            cell.setStringValue("Foo " + a);
            cell.setCellStyleName("myss");
        }
    }
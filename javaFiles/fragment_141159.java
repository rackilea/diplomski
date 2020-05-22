CellData setUserEnteredValue = new CellData()
            .setUserEnteredValue(new ExtendedValue().setStringValue("example text"));

    CellFormat cellFormat = new CellFormat();
    cellFormat.setTextFormat(new TextFormat().setBold(true));

    setUserEnteredValue.setUserEnteredFormat(cellFormat);
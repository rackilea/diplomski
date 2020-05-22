List<Request> requests = new ArrayList<Request>();
for (SheetData mySheet : sheetDatas)
{
    List<List<Object>> values = mySheet.getValues();
    Request clearSheetRequest = new Request()
          .setRepeatCell(new RepeatCellRequest()
            .setRange(new GridRange()
              .setSheetId(mySheet.getSheetId())
            )
            .setFields("*")
            .setCell(new CellData())
          );

    List<RowData> preppedRows = new ArrayList<RowData>();
    for (List<Object> row : values)
    {
    RowData preppedRow = new RowData();
    List<CellData> cells = new ArrayList<CellData>();
    for (Object value : row)
    {
        CellData cell = new CellData();
        ExtendedValue userEnteredValue = new ExtendedValue();
        if (value instanceof String)
        {
            userEnteredValue.setStringValue((String) value);
        }
        else if (value instanceof Double)
        {
            userEnteredValue.setNumberValue((Double) value);
        }
        else if (value instanceof Integer)
        {
            userEnteredValue.setNumberValue(Double.valueOf((Integer) value).doubleValue());
        }
        else if (value instanceof Boolean)
        {
            userEnteredValue.setBoolValue((Boolean) value);
        }
        cell.setUserEnteredValue(userEnteredValue);
        cells.add(cell);
    }
    preppedRow.setValues(cells);
    preppedRows.add(preppedRow);
    }

    Request appendCellsRequest = new Request().setAppendCells(
    new AppendCellsRequest()
        .setSheetId(mySheet.getSheetId())
        .setRows(preppedRows)
        .setFields("*")
        );

    requests.add(clearSheetRequest);
    requests.add(appendCellsRequest);
}

BatchUpdateSpreadsheetRequest batch = new BatchUpdateSpreadsheetRequest().setRequests(requests);
BatchUpdateSpreadsheetResponse batchResponse = service.spreadsheets().batchUpdate(idSpreadsheet, batch).execute();
//Inserts row at index, this is hardcoded to row 2 (0-indexed)
private static void insertRow(Sheets ss, String sheetID)throws IOException{
    InsertDimensionRequest insertRow = new InsertDimensionRequest();
    insertRow.setRange(new DimensionRange().setDimension("ROWS").setStartIndex(1).setEndIndex(2).setSheetId(0));

    BatchUpdateSpreadsheetRequest r = new BatchUpdateSpreadsheetRequest().setRequests(Arrays.asList(
            new Request().setInsertDimension(insertRow)
    ));
    ss.spreadsheets().batchUpdate(sheetID, r).execute();
}
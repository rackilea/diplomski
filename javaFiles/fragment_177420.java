BatchUpdateSpreadsheetRequest batchUpdateSpreadsheetRequest = new 
BatchUpdateSpreadsheetRequest();

List<Request> requests = new ArrayList<>();

DuplicateSheetRequest requestBody = new DuplicateSheetRequest();
requestBody.setNewSheetName("test");
requestBody.setSourceSheetId(sheetId);

requests.add(new Request().setDuplicateSheet(requestBody));

Sheets sheetsService = createSheetsService();

batchUpdateSpreadsheetRequest.setRequests(requests);
Sheets.Spreadsheets.BatchUpdate request =
            sheetsService.spreadsheets().batchUpdate(spreadsheetId, batchUpdateSpreadsheetRequest);

BatchUpdateSpreadsheetResponse response = request.execute();
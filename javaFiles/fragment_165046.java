//Creates a new row at row 2 then writes data to it...
static void writeTest(Report r, String sheetID, String range)throws GeneralSecurityException, IOException{
    final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
    ValueRange requestBody = requestBuilder(r, range);
    Sheets sheetsService = new Sheets.Builder(HTTP_TRANSPORT,JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
            .setApplicationName(APPLICATION_NAME)
            .build();
    insertRow(sheetsService, sheetID);
    Sheets.Spreadsheets.Values.Append request =
            sheetsService.spreadsheets().values().append(sheetID, range, requestBody);
    request.setValueInputOption("RAW");
    //request.setInsertDataOption("INSERT_ROWS");
    AppendValuesResponse resp = request.execute();

    System.out.println(resp);
}
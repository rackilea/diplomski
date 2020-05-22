{

    File infoFile = new File(readfileName);

    Workbook infoWorkBook = Workbook.getWorkbook(infoFile);

    Sheet infoSheet = infoWorkBook.getSheet(readsheetName);
    int infoRows = infoSheet.getRows();

    int infoColumns = infoSheet.getColumns();

    String[][] column = new String[infoColumns][infoRows];

    for(int i=1; i< infoRows; i++)

    {

    for(int j1=0; j1<infoColumns; j1++)

    {
    column[j1][i] = infoSheet.getCell(j1, i).getContents();
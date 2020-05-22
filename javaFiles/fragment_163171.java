Workbook workbook = Workbook.getWorkbook(new java.io.File("aaa.xls"));
Sheet sheet = workbook.getSheet(0);
int rowCount = sheet.getRows();
int startingRowPosition = 2;
for(int i = startingRowPosition; i < rowCount; i++)
{
    String login = sheet.getCell(0, i).getContents();
    String password = sheet.getCell(1, i).getContents();

    System.out.println("Login: " + login + " Password: " + password);
}
workbook.close();
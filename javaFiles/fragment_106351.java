//Range Iterator.
Workbook book = new Workbook("sample.xlsx");
Worksheet sheet = book.getWorksheets().get(0);
Range range = sheet.getCells().getMaxDisplayRange();//You may also create your desired range (in the worksheet) using, e.g sheet.getCells().createRange("A1", "J11");
Iterator rangeIterator = range.iterator();
while(rangeIterator.hasNext())
{
Cell cell = (Cell)rangeIterator.next();
System.out.println(cell.getName() + " is not empty");
}

//Cells Iterator.
Workbook workbook = new Workbook("Book1.xls"); 
Worksheet sheet = workbook.getWorksheets().get(0);
Cells cells = sheet.getCells();
//Get the iterator from Cells collection
Iterator cellIterator = cells.iterator();
//Traverse cells in the collection
while (cellIterator.hasNext()) {
      Cell cell = (Cell) cellIterator.next();
      System.out.println(cell.getName() + " " + cell.getValue());
}

//Rows collection Iterator.
String filePath = "c:\\source.xlsx";

Workbook workbook = new Workbook(filePath);

Worksheet worksheet = workbook.getWorksheets().get(0);

RowCollection rows =  worksheet.getCells().getRows();

Object obj = rows.iterator().next();

Iterator<Row> rowIterator = worksheet.getCells().getRows().iterator();

while(rowIterator.hasNext())

{

      Row r = rowIterator.next();

      Iterator<Cell> cellIterator = r.iterator();

      while(cellIterator.hasNext())

      {

            Cell cell= cellIterator.next();
            System.out.println(cell.getStringValue());

      }

}
int n1ColIndex = 0;    // 0-based.    this is the index of row in excel.
int n2ColIndex = 1;    // 
int n3ColIndex = 2;
int n4ColIndex = 3;

// then you can read cell by Row.getCell() method.

// below code, you can put in loop.
XSSFCell n1Cell = row.getCell(n1ColIndex);
if ( n1Cell == null ){
    continue;
}

String n1Col = n1Cell.getStringCellValue();
if( "B".equals(n1Col) ) {
    // get r45 value.

    XSSFCell n4Cell = row.getCell(n4ColIndex);
    if ( n4Cell == null ){
        continue;
    }

    String val = n4Cell.getStringCellValue();
    // this value will be 34 or r45
    // Do you understand ?

}

// update 1. how to get a row.

// method 1.
Iterator<Row> rowIterator = sheet.iterator();
while (rowIterator.hasNext())
{
    Row row = rowIterator.next();

    // do something with the row var.
}

// method 2.
for ( int index=0; index < sheet.getLastRowNum(); index++){
    Row row = sheet.getRow(index);

    // check null.
    if ( row == null ){
        continue;
    }

    // do something with the row var.

}
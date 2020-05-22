Row row = rowIterator.next();
short firstCellNumber = row.getFirstCellNum();
short lastCellNumber = row.getLastCellNum();
for(short cellNumber = firstCellNumber; cellNumber < lastCellNumber; cellNumber++) {
    Cell dataCell = row.getCell(cellNumber);
    //Do something with the dataCell here
}
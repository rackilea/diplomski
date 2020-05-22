Iterator sheetInterator = new Itertor();
Set<Object> set = new HashSet();
while(sheetInterator.hasNext()) { 
    Row myrow = (Row) obj.next();
    Iterator rowIterator = myrow.iterator();
    while(rowIterator.hasNext()) {
        Cell cell = (Cell) rowIterator.next();
        String value = cell.getValue();
        if(!set.add(value)){
            // value has not been added to the set -> it is at least 2nd occurrence of this value 
        }
    }
}
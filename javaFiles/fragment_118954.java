if(cell.getCellTypeEnum() == CellType.STRING){
    Hyperlink hyperlink = cell.getHyperlink();
    String value = cell.getRichStringCellValue().getString();
    if(hyperlink == null) {
        return value;
    } else {
        return value + " " + hyperlink.getAddress(); 
    }
}
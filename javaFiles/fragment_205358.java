private String getCellValue(int x, int y)
{
    if( pageTable.getValueAt(x, y) == null) {
        return "";
    } else {
        pageTable.getValueAt(x, y).toString();
    }
}
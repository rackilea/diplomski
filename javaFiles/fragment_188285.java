int matchIndex = -1;
for (int rowIndex = 0; rowIndex < myJTable.getRowCount(); index++) {
    Object value = myJTable.getValueAt(rowIndex, colIndex);
    if (value.equals(timestamp)) { // Or what ever comparison you need..
        matchIndex = rowIndex;
        break;
    } 
}
return matchIndex;
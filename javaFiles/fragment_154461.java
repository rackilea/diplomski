if (isSelected) {
    setBackground(table.getSelectionBackground());
}
else {
    if ( row % 2 == 0 ) {
       setBackground(UIManager.getColor("Table.alternateRowColor"));
    } else { 
       setBackground(table.getBackground());
    }
}
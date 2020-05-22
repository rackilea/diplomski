TableColumn<...> columnOfInterest = ... ;
int rowIndexOfInterest = ... ;

TableCell<?, ?> cell = null ;
for (Node n : table.lookupAll(".table-cell")) {
    TableCell<?,?> c = (TableCell<?,?>) n ;
    if (c.getTableColumn() == columnOfInterest 
            && c.getIndex() == rowIndexOfInterest) {
        cell = c ;
        break ;
    }
}

if (cell != null) {
    // ...
}
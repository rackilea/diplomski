table.lookupAll(".table-cell").stream()
    .map(TableCell.class::cast)
    .filter(c -> c.getTableColumn() == columnOfInterest && c.getIndex() == rowIndexOfInterest)
    .findAny()
    .ifPresent(cell -> {
        // do whatever you need with the cell....
    });
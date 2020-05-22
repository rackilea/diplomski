// Group headers by joining the cells
HeaderRow groupingHeader = grid.prependHeaderRow();
HeaderCell namesCell = groupingHeader.join(
    groupingHeader.getCell("firstname"),
    groupingHeader.getCell("lastname"));
HeaderCell yearsCell = groupingHeader.join(
    groupingHeader.getCell("born"),
    groupingHeader.getCell("died"),
    groupingHeader.getCell("lived"));
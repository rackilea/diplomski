while (cell != null && !(cell.toString().equals(""))) 
{
    // We know that cell isn't null before this line...
    cell = headingsRow.getCell(i);

    // ... but now we've got a new value for cell, which could be null
    columnHeading = cell.toString();
    columnHeadings.add(columnHeading);
    i++;
}
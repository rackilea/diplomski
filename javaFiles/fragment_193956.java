while (cell != null && !(cell.toString().equals(""))) 
{
    // We know cell isn't null for this...
    columnHeading = cell.toString();
    columnHeadings.add(columnHeading);

    i++;
    // It's fine to set cell to null here... we'll be
    // checking again in a second...
    cell = headingsRow.getCell(i);
}
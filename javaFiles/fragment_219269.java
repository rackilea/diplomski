public void createRow(boolean lastRow, CellElement... cells)
{
    for(CellElement currentCell : cells)
    {
        if(currentCell==null)
        {
            continue;
        }
        Cell cell = new Cell();
        cell.add(new Paragraph(currentCell.getText()))
                .setBorder(new SolidBorder(Color.BLACK, 0.5f))
                .setBackgroundColor(currentCell.getBackgroundColor());
        currentTable.addCell(cell);
    }
    if (!lastRow) {
        currentTable.startNewRow();
    }
}
private void showSearchResults(List<Point> results)
{

    for (Point p : results) 
    {
        int col = p.x;
        int row = p.y;
        CustomRenderer renderer = (CustomRenderer)table8.getCellRenderer(row, col);
        renderer.setTargetCell(row, col);
        Rectangle r8 = table8.getCellRect(row, col, false);
        table8.scrollRectToVisible(r8);
    }
    table8.repaint();
}
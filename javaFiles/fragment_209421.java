private void drawHeatMap(Graphics2D chartGraphics, double[][] data) {
    …
    Graphics2D heatMapGraphics = heatMapImage.createGraphics();
    for (int x=0; x<noXCells; x++) {
        for (int y=0; y<noYCells; y++) {
            // Set colour depending on zValues.
            heatMapGraphics.setColor(getCellColour(data[y][x], lowValue, highValue));
            int cellX = x*cellSize.width;
            int cellY = y*cellSize.height;
            heatMapGraphics.fillRect(cellX, cellY, cellSize.width, cellSize.height);
            // Draw boundary 
            Rectangle2D block = new Rectangle2D.Double(
                cellX, cellY, cellSize.width, cellSize.height));
            heatMapGraphics.setPaint(boundaryColor);
            heatMapGraphics.draw(block);
        }
    }
    …
}
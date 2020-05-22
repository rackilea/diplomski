private static class CustomTableRenderer extends TableRenderer {
    public CustomTableRenderer(Table modelElement) {
        super(modelElement);
    }

    @Override
    public IRenderer getNextRenderer() {
        CustomTableRenderer nextTable = new CustomTableRenderer((Table) modelElement);
        nextTable.rows.clear();
        nextTable.rowRange = null;
        return nextTable;
    }

    @Override
    protected void drawBorders(DrawContext drawContext) {
        PdfCanvas canvas = drawContext.getCanvas();
        canvas.saveState();
        canvas.setStrokeColor(ColorConstants.RED);

        Random r = new Random();

        // Draw vertical lines
        float curX = getOccupiedAreaBBox().getLeft();
        for (int i = 0; i <= countedColumnWidth.length; i++) {
            canvas.moveTo(curX, getOccupiedAreaBBox().getTop() + 3);
            canvas.lineTo(curX + r.nextInt(4), getOccupiedAreaBBox().getBottom() - 3);
            if (i < countedColumnWidth.length) {
                float curWidth = countedColumnWidth[i];
                curX += curWidth;
            }
        }

        // Draw horizontal lines
        float curY = getOccupiedAreaBBox().getBottom();
        for (int i = 0; i <= heights.size(); i++) {
            canvas.moveTo(getOccupiedAreaBBox().getLeft() - 3, curY);
            canvas.lineTo(getOccupiedAreaBBox().getRight() + 3, curY + r.nextInt(4));
            if (i < heights.size()) {
                float curHeight = heights.get(i);
                curY += curHeight;
            }
        }

        canvas.stroke();
        canvas.restoreState();
    }
}
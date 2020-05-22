private class DottedLineTableRenderer extends TableRenderer {
    public DottedLineTableRenderer(Table modelElement, Table.RowRange rowRange) {
        super(modelElement, rowRange);
    }

    @Override
    public void drawChildren(DrawContext drawContext) {
        super.drawChildren(drawContext);
        PdfCanvas canvas = drawContext.getCanvas();
        canvas.setLineDash(3f, 3f);
        // first horizontal line
        CellRenderer[] cellRenderers = rows.get(0);
        canvas.moveTo(cellRenderers[0].getOccupiedArea().getBBox().getLeft(),
                cellRenderers[0].getOccupiedArea().getBBox().getTop());
        canvas.lineTo(cellRenderers[cellRenderers.length - 1].getOccupiedArea().getBBox().getRight(),
                cellRenderers[cellRenderers.length - 1].getOccupiedArea().getBBox().getTop());

        for (int i = 0; i < rows.size(); i++) {
            cellRenderers = rows.get(i);
            // horizontal lines
            canvas.moveTo(cellRenderers[0].getOccupiedArea().getBBox().getX(),
                    cellRenderers[0].getOccupiedArea().getBBox().getY());
            canvas.lineTo(cellRenderers[cellRenderers.length - 1].getOccupiedArea().getBBox().getRight(),
                    cellRenderers[cellRenderers.length - 1].getOccupiedArea().getBBox().getBottom());
            // first vertical line
            Rectangle cellRect = cellRenderers[0].getOccupiedArea().getBBox();
            canvas.moveTo(cellRect.getLeft(), cellRect.getBottom());
            canvas.lineTo(cellRect.getLeft(), cellRect.getTop());
            // vertical lines
            for (int j = 0; j < cellRenderers.length; j++) {
                cellRect = cellRenderers[j].getOccupiedArea().getBBox();
                canvas.moveTo(cellRect.getRight(), cellRect.getBottom());
                canvas.lineTo(cellRect.getRight(), cellRect.getTop());
            }
        }
        canvas.stroke();
    }
}
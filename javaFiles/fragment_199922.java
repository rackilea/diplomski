private class DottedLineCellRenderer extends CellRenderer {
    public DottedLineCellRenderer(Cell modelElement) {
        super(modelElement);
    }

    @Override
    public void draw(DrawContext drawContext) {
        super.draw(drawContext);
        drawContext.getCanvas().setLineDash(3f, 3f);
        drawContext.getCanvas().rectangle(this.getOccupiedArea().getBBox());
        drawContext.getCanvas().stroke();
    }
}
protected class DashedLineTextRenderer extends TextRenderer {
    public DashedLineTextRenderer(Text textElement) {
        super(textElement);
    }

    @Override
    public void draw(DrawContext drawContext) {
        super.draw(drawContext);
        Rectangle rect = this.getOccupiedAreaBBox();
        PdfCanvas canvas = drawContext.getCanvas();
        canvas
                .saveState()
                .setLineDash(3, 3)
                .moveTo(rect.getLeft(), rect.getBottom() - 3)
                .lineTo(rect.getRight(), rect.getBottom() - 3)
                .stroke()
                .restoreState();
    }
}
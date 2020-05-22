private static class CustomDashedLine extends DashedLine {
    public CustomDashedLine(float lineWidth) {
        super(lineWidth);
    }

    @Override
    public void draw(PdfCanvas canvas, Rectangle drawArea) {
        canvas.saveState()
                .setLineWidth(getLineWidth())
                .setStrokeColor(getColor())
                .setLineDash(20, 4, 2)
                .moveTo(drawArea.getX(), drawArea.getY() + getLineWidth() / 2)
                .lineTo(drawArea.getX() + drawArea.getWidth(), drawArea.getY() + getLineWidth() / 2)
                .stroke()
                .restoreState();
    }
}
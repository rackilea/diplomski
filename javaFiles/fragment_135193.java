float y;

    public MyParagraphRenderer(Paragraph modelElement) {
        super(modelElement);
    }

    @Override
    public void drawBorder(DrawContext drawContext) {
        super.drawBorder(drawContext);
        y = getOccupiedAreaBBox().getBottom();
    }

    public float getY() {
        return y;
    }

}
class CustomDocumentRenderer extends DocumentRenderer {
    public CustomDocumentRenderer(Document document) {
        super(document);
    }

    @Override
    public IRenderer getNextRenderer() {
        return new CustomDocumentRenderer(this.document);
    }

    @Override
    protected LayoutArea updateCurrentArea(LayoutResult overflowResult) {
        LayoutArea area = super.updateCurrentArea(overflowResult);
        if (currentPageNumber > 1) {
            area.setBBox(area.getBBox().decreaseHeight(200));
        }  
        return area;
    }
}
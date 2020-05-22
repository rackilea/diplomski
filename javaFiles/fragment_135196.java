class MyColumnDocumentRenderer extends ColumnDocumentRenderer {

    Rectangle[] columns2;

    public MyColumnDocumentRenderer(Document document, Rectangle[] columns1, Rectangle[] columns2) {
        super(document, columns1);
        this.columns2 = columns2;
    }

    @Override
    protected PageSize addNewPage(PageSize customPageSize) {
        PageSize size = super.addNewPage(customPageSize);
        columns = columns2;
        return size;
    }
}
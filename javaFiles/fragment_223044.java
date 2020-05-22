public class XHTMLCellMarkTagProcessor extends TableData {

    private PdfWriter writer;

    public XHTMLCellMarkTagProcessor(PdfWriter writer) {
        this.writer = writer;
    }

    @Override
    public List<Element> end(WorkerContext ctx, Tag tag, List<Element> currentContent) {
        String mark = "mark";
        String strMark = tag.getAttributes().get(mark);
        String strName = tag.getAttributes().get("name");
        boolean isMark = StringUtils.isAlpha(strMark) && strMark.equalsIgnoreCase("true");

        List<Element> retval = super.end(ctx, tag, currentContent);

        if (isMark && StringUtils.isNotBlank(strName)) {
            for (Element element : retval) {
                if (element instanceof PdfPCell) {
                    final TextField namedField = new TextField(writer, new Rectangle(0, 0, 10, 5), strName);
                    try {

                        final PdfFormField formField = namedField.getTextField();
                        final int width = 0;

                        PdfPCellEvent cellEvent = new PdfPCellEvent() {
                            @Override
                            public void cellLayout(PdfPCell cell, Rectangle position, PdfContentByte[] canvas) {
                                try {
                                    formField.setWidget(new Rectangle(position.getLeft(), position.getBottom(), position.getLeft() + width,
                                            position.getTop()), PdfAnnotation.HIGHLIGHT_NONE);
                                    writer.addAnnotation(formField);

                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        };

                        ((PdfPCell) element).setCellEvent(cellEvent);

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        return retval;
    }
}
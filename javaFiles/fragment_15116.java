class SelectCellEvent implements PdfPCellEvent {
    protected PdfFormField selectGroup;
    protected String name;
    protected String[] exports;
    protected String[] options;
    protected BaseFont font;

    public SelectCellEvent(PdfFormField selectGroup, String name, String[] exports, String[] options) throws DocumentException, IOException {
        this.selectGroup = selectGroup;
        this.name = name;
        this.exports = exports;
        this.options = options;
        font = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1250, BaseFont.NOT_EMBEDDED);
        font.setSubset(false);
    }

    public void cellLayout(PdfPCell cell, Rectangle position, PdfContentByte[] canvases) {
        PdfWriter writer = canvases[0].getPdfWriter();
        TextField tf = new TextField(writer, position, name);
        tf.setFont(font);
        tf.setBorderStyle(PdfBorderDictionary.STYLE_BEVELED);
        tf.setVisibility(TextField.VISIBLE_BUT_DOES_NOT_PRINT);
        tf.setBorderColor(BaseColor.GRAY);
        tf.setChoiceExports(exports);
        tf.setChoices(options);
        tf.setAlignment(Element.ALIGN_CENTER);
        try {
            selectGroup.addKid(tf.getComboField());
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }
}
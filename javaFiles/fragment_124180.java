public static final String JAPANESE = "\u3042\u304d\u3089";
public static final String FONT = "resources/fonts/FreeSans.ttf";

public void createPdf(String dest) throws IOException, DocumentException {
    Document document = new Document();
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
    document.open();
    PushbuttonField button = new PushbuttonField(writer, new Rectangle(36, 780, 144, 806), "japanese");
    BaseFont bf = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
    button.setFont(bf);
    button.setText(JAPANESE);
    writer.addAnnotation(button.getField());
    document.close();
}
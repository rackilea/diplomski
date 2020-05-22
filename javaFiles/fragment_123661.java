public class TablePrinter {
    static PdfDocument pdfDoc;
    Table tble;
    protected int nextAreaNumber = 0;

    public TablePrinter() {

    }

    public static final String DEST = "./target/test/resources/sandbox/tables/tables_printed.pdf";

    public void createPdf(String dest) throws IOException, java.io.IOException {
    //
    PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
    PdfFont bold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);

    pdfDoc = new PdfDocument(new PdfWriter(dest));
    PdfPage page = pdfDoc.addNewPage();
    PdfCanvas pdfCanvas = new PdfCanvas(page);
    Rectangle rectangle = new Rectangle(70, 722, 200, 100);
    pdfCanvas.rectangle(rectangle);
    pdfCanvas.stroke();
    Canvas canvas = new Canvas(pdfCanvas, pdfDoc, rectangle);
    Text title = new Text("The Strange Case of Dr. Jekyll and Mr. Hyde")
        .setFont(bold);
    Text author = new Text("Robert Louis Stevenson").setFont(font);
    Paragraph p = new Paragraph().add(title).add(" by ").add(author);
    canvas.add(p);

    rectangle = new Rectangle(310, 722, 200, 100);
    pdfCanvas.rectangle(rectangle);
    pdfCanvas.stroke();
    canvas.close();
    canvas = new Canvas(pdfCanvas, pdfDoc, rectangle);

    tble = new Table(new float[] { 3f, 3f, 3f, 3f, 3f, 3f, 3f });
    /*tble.addCell(new Cell()
        .add(new Paragraph(tokenizer.nextToken()).setFont(font)));*/

    int DaysInMonth = 31;
    for (int i = 1; i <= 35; i++) {
        if (i <= DaysInMonth) {
        tble.addCell(new Cell().add(new Paragraph(Integer.toString(i))
            .setTextAlignment(TextAlignment.RIGHT)
            .setFontSize((float) 8.0)));
        if ((i >= DaysInMonth) && (i % 7 == 0))
            break;
        } else {
        tble.addCell(new Cell());
        if (i % 7 == 0)
            break;
        }
    }
    p = new Paragraph().add(tble);
    canvas.add(p);

    canvas.close();
    pdfDoc.close();
    //
    }

    public void addParagraph(Document document, int count) {
    Paragraph p;
    TextAlignment alignment;
    for (int i = 1; i < count + 1; i++) {
        p = new Paragraph("entry" + String.valueOf(i));
        alignment = (i % 2 != 0) ? TextAlignment.LEFT : TextAlignment.RIGHT;
        p.setTextAlignment(alignment);
        document.add(p);
    }
    }

    public static void main(String[] args)
        throws IOException, java.io.IOException {

    File file = new File(DEST);
    file.getParentFile().mkdirs();
    new TablePrinter().createPdf(DEST);
    }

}
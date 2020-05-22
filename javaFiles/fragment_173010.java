private final PDDocument document;
private final PDPage page;
private final PDFont font;

public PdfBoxWrapper(PDDocument document, PDPage page, PDFont font)
{
    this.document = document;
    this.page = page;
    this.font = Objects.isNull(font) ? PDType1Font.HELVETICA : font;

    this.document.addPage(this.page);

    try 
    {
        this.canvas = new PDPageContentStream(this.document, this.page);
    } 

    catch (IOException exception) {
        logger.error(exception.getMessage());
        throw new PdfBoxIllegalStateException(exception);
    }
}
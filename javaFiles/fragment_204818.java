// create a Phrase with a certain font
Font font = font(Font.NORMAL, 135, Color.RED);
Phrase p = new Phrase("WATERMARK", font);
// Create a reader and a stamper
PdfReader reader = new PdfReader(getAsByteArray());
ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
PdfStamper stamper = new PdfStamper(reader, outputStream);
int numberOfPages= reader.getNumberOfPages();
for (int i = 1; i <= numberOfPages; i++) {
     PdfContentByte over = stamper.getOverContent(i);
     over.saveState();
     PdfGState gs = new PdfGState();
     gs.setFillOpacity(0.5f);
     over.setGState(gs);
     ColumnText.showTextAligned(over, Element.ALIGN_CENTER, p, 330, 450, 45);
     over.restoreState();
}
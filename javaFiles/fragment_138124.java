...
PDPageContentStream contentStream = new PDPageContentStream(
        document, page, true, true, true);
contentStream.saveGraphicsState();
contentStream.beginText();
// set font and font size
contentStream.setFont(pdfFont, fontSize);
// set text color to red
contentStream.setNonStrokingColor(240, 240, 240);
if (rotate) {
    // rotate the text according to the page rotation
    contentStream.setTextRotation(degree, x, y);
} else {
    contentStream.setTextTranslation(centeredXPosition,
            centeredYPosition);
}
contentStream.drawString(text);
contentStream.endText();
contentStream.restoreGraphicsState();
contentStream.close();
...
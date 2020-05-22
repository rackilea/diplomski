PdfDocument pdfDocument = new PdfDocument(new PdfWriter(outFilePath));
pdfDocument.setTagged();

PdfPage firstPage = pdfDocument.addNewPage();

PdfCanvas canvas = new PdfCanvas(firstPage);

TagTreePointer tagPointer = new TagTreePointer(pdfDocument);
tagPointer.setPageForTagging(firstPage);
tagPointer.addTag(StandardRoles.P).addTag(StandardRoles.SPAN);

canvas.beginText()
        .setFontAndSize(PdfFontFactory.createFont(), 12)
        .openTag(tagPointer.getTagReference())
        .showText("Test for Accessibility")
        .closeTag()
        .stroke();

tagPointer.moveToParent().addTag(StandardRoles.SPAN).getProperties().setExpansion("Eyes Wide Shut");
canvas.openTag(tagPointer.getTagReference())
        .newlineShowText("EWS")
        .closeTag()
        .endText();

pdfDocument.close();
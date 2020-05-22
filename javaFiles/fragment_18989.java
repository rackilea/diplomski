PdfDocument pdfDocument = new PdfDocument(new PdfWriter(outFileName));
    Document document = new Document(pdfDocument);

    Div div = new Div()
            .setWidth(500)
            .setBackgroundColor(ColorConstants.YELLOW);

    Paragraph paragraph = new Paragraph("Hello World!")
            .setTextAlignment(TextAlignment.CENTER)
            .setHorizontalAlignment(HorizontalAlignment.RIGHT)
            .setWidth(300)
            .setBackgroundColor(ColorConstants.BLUE);

    div.add(paragraph);
    document.add(div);
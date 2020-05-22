PdfDocument pdfDoc = new PdfDocument(new PdfWriter(outFileName));
    Document doc = new Document(pdfDoc);

    Table table = new Table(new float[] {50, 50 });

    Paragraph headerParagraph = new Paragraph();
    Text headerTitle = new Text("Title of PDF")
            .setFontSize(20)
            .setFontColor(new DeviceRgb(0, 128, 128));
    Text headerDescription = new Text("Description")
            .setFontSize(11);

    headerParagraph.add(headerTitle);
    headerParagraph.add(headerDescription);

    table.addCell(new Cell().add("logo").setBorder(Border.NO_BORDER));
    table.addCell(new Cell().add(headerParagraph).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));

    doc.add(table);
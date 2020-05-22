PDPage page1, page2;

    page1 = new PDPage();
    page2 = new PDPage();

    Splitter splitter = new Splitter();
    PDDocument document = new PDDocument();

    document.addPage(page1);
    document.addPage(page2);

    PDFont font = PDType1Font.HELVETICA_BOLD;

    PDPageContentStream contentStream = new PDPageContentStream(document, page1);

    contentStream.beginText();
    contentStream.setFont(font, 50);
    contentStream.moveTextPositionByAmount(100, 700);
    contentStream.drawString("First page");
    contentStream.endText();

    contentStream.close();
    // now the page is filled!


    List<PDDocument> splittedPDF = splitter.split(document);

    document = splittedPDF.get(0);
    document.save("Random.pdf");
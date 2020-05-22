// iteration == a new page
    for(int i=0 ; i < 3 ; i++)
    {
        PDPage page = documentSource.getDocumentCatalog().getPages().get(0);
        page = documentTarget.importPage(page); // this is now a new PDPage object
        PDPageContentStream contentStream = new PDPageContentStream(documentSource, page, true, true);

        PDFont font1 = PDType1Font.HELVETICA;

        float startY = page.getMediaBox().getUpperRightY();
        float factor = 2.83f;

        page.getStream();

        // add text
        contentStream.beginText();
        contentStream.setFont(font1, 10);
        contentStream.newLineAtOffset(factor * 60, startY - (factor * 53));
        contentStream.showText("test text" + i);
        contentStream.endText();

        contentStream.close();            
    }
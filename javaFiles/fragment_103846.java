Document itextDocument = new Document(PageSize.A4, 50, 50, 30, 65);
    PdfWriter writer = PdfWriter.getInstance(itextDocument, new FileOutputStream(RESULT));
    itextDocument.open();

    PdfContentByte canvas = writer.getDirectContent();
    BaseFont romanFont = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);

    // first page content
    canvas.setFontAndSize(romanFont, 10);
    canvas.beginText();
    canvas.showTextAligned(Element.ALIGN_LEFT, "Line 1 on page 1", 50, 800, 0); 
    canvas.showTextAligned(Element.ALIGN_LEFT, "Line 2 on page 1", 50, 785, 0); 
    canvas.showTextAligned(Element.ALIGN_LEFT, "Line 3 on page 1", 50, 770, 0); 
    canvas.showTextAligned(Element.ALIGN_LEFT, "................", 50, 755, 0); 
    canvas.showTextAligned(Element.ALIGN_LEFT, "................", 50, 740, 0); 
    canvas.showTextAligned(Element.ALIGN_LEFT, "................", 50, 725, 0);
    canvas.setFontAndSize(romanFont, 800);
    canvas.showTextAligned(Element.ALIGN_LEFT, "1", 0, 100, 0); 
    canvas.endText();

    itextDocument.newPage();

    // first page content
    canvas.setFontAndSize(romanFont, 10);
    canvas.beginText();
    canvas.showTextAligned(Element.ALIGN_LEFT, "Line 1 on page 2", 50, 800, 0); 
    canvas.showTextAligned(Element.ALIGN_LEFT, "Line 2 on page 2", 50, 785, 0); 
    canvas.showTextAligned(Element.ALIGN_LEFT, "Line 3 on page 2", 50, 770, 0); 
    canvas.showTextAligned(Element.ALIGN_LEFT, "................", 50, 755, 0); 
    canvas.showTextAligned(Element.ALIGN_LEFT, "................", 50, 740, 0); 
    canvas.showTextAligned(Element.ALIGN_LEFT, "................", 50, 725, 0); 
    canvas.setFontAndSize(romanFont, 800);
    canvas.showTextAligned(Element.ALIGN_LEFT, "2", 0, 100, 0); 
    canvas.endText();

    itextDocument.close();
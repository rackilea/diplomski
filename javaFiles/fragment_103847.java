Document document = new Document(PageSize.A4);

    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("big-panel.pdf"));
    document.open();
    PdfContentByte cb = writer.getDirectContent();
    PdfTemplate tp = cb.createTemplate(PageSize.A4.getWidth(), 3 * PageSize.A4.getHeight());

    // draw all your content on tp

    cb.addTemplate(tp, 0, -2 * PageSize.A4.getHeight());
    document.newPage();
    cb.addTemplate(tp, 0, -PageSize.A4.getHeight());
    document.newPage();
    cb.addTemplate(tp, 0, 0);
    document.newPage();
    cb.addTemplate(tp, 0.3333f, 0, 0, 0.3333f, PageSize.A4.getWidth() / 3, 0);
    document.close();
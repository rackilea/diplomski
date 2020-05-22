baos = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4, 60, 60, 120, 80);
        PdfWriter writer = PdfWriter.getInstance(document, baos);
        HeaderAndFooter event = new HeaderAndFooter();
        writer.setPageEvent(event);
        document.open();
ByteArrayOutputStream out = new ByteArrayOutputStream();

    ITextRenderer renderer = new ITextRenderer();
    renderer.getFontResolver().addFont("fonts/VERDANA.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
    renderer.getFontResolver().addFont("fonts/VERDANAB.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
    renderer.getFontResolver().addFont("fonts/VERDANAI.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
    renderer.getFontResolver().addFont("fonts/VERDANAZ.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
    renderer.setDocumentFromString(... HTML as a String ...);
    renderer.layout();
    renderer.createPDF(out);

    FileOutputStream fos = new FileOutputStream(pathPdf);

    PdfReader reader = new PdfReader(baos.toByteArray());
    PdfStamper stamper = new PdfStamper(reader, fos);

    ... sets watermark image if available ...

    PdfDictionary info = reader.getTrailer().getAsDict(PdfName.INFO);
    info.getKeys().forEach((k) -> {
        System.out.println("k: " + k + ", v:" + info.get((PdfName) k));
    });
    info.put(PdfName.TITLE, new PdfString("Title", PdfObject.TEXT_UNICODE));
    info.put(PdfName.AUTHOR, new PdfString("Author", PdfObject.TEXT_UNICODE));

    stamper.close();
    reader.close();
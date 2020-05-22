PdfReader reader = new PdfReader(INTERMEDIATE);
PdfStamper stamper = new PdfStamper(reader, FINAL_RESULT);

PdfReaderContentParser parser = new PdfReaderContentParser(reader);
TextMarginFinder finder = parser.processContent(1, new TextMarginFinder());

PdfDictionary page = reader.getPageN(1);
page.put(PdfName.CROPBOX, new PdfArray(new float[]{pageSize.getLeft(), finder.getLly(), pageSize.getRight(), pageSize.getTop()}));
stamper.markUsed(page);

stamper.close();
reader.close();
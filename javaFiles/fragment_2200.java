File file = new File("test.pdf");

    PDDocument doc = PDDocument.load(file);
    Map<String, COSBase> fontFileCache = new HashMap<>();
    for (int pageNumber = 0; pageNumber < doc.getNumberOfPages(); pageNumber++) {
        final PDPage page = doc.getPage(pageNumber);
        COSDictionary pageDictionary = (COSDictionary) page.getResources().getCOSObject().getDictionaryObject(COSName.FONT);
        for (COSName currentFont : pageDictionary.keySet()) {
            COSDictionary fontDictionary = (COSDictionary) pageDictionary.getDictionaryObject(currentFont);
            for (COSName actualFont : fontDictionary.keySet()) {
                COSBase actualFontDictionaryObject = fontDictionary.getDictionaryObject(actualFont);
                if (actualFontDictionaryObject instanceof COSDictionary) {
                    COSDictionary fontFile = (COSDictionary) actualFontDictionaryObject;
                    if (fontFile.getItem(COSName.FONT_NAME) instanceof COSName) {
                        COSName fontName = (COSName) fontFile.getItem(COSName.FONT_NAME);
                        fontFileCache.computeIfAbsent(fontName.getName(), key -> fontFile.getItem(COSName.FONT_FILE2));
                        fontFile.setItem(COSName.FONT_FILE2, fontFileCache.get(fontName.getName()));
                    }
                }
            }
        }
    }

    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    doc.save(baos);
    final File compressed = new File("test_compressed.pdf");
    baos.writeTo(new FileOutputStream(compressed));
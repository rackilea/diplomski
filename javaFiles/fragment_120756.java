PDDocument doc = PDDocument.load(new File(...));
    PDPage page = doc.getPage(0); // 0 based
    PDResources resources = page.getResources();
    for (COSName fontName : resources.getFontNames())
    {
        System.out.println(fontName.getName());
    }
    doc.close();
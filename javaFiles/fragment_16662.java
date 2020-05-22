PDDocument doc = PDDocument.load( file );

List<PDPage> allPages = doc.getDocumentCatalog().getAllPages();

PDPage page = allPages.get(0);
COSDictionary pageDict = page.getCOSDictionary();
COSDictionary newPageDict = new COSDictionary(pageDict);

newPageDict.removeItem(COSName.ANNOTS);

PDPage newPage = new PDPage(newPageDict);
doc.addPage(newPage);

doc.save( outfile );
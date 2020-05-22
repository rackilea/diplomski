// read the existing document
PDDocument doc;
doc = PDDocument.load(musiqueFileName);
List<?> pages = doc.getDocumentCatalog().getAllPages();
PDPage page = (PDPage) pages.get(0);

PDPageContentStream content = new PDPageContentStream(doc, page, true, true);

TestRewriter rewriter = new TestRewriter(content);
rewriter.processStream(page, page.findResources(), page.getContents().getStream());

content.close();

// save the modified document
doc.save(modifiedMusiqueFileName);
doc.close();
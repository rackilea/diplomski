doc.getDocumentCatalog().setLanguage("en-US");

PDMarkInfo mark = new PDMarkInfo(); // new PDMarkInfo(page.getCOSObject());
PDStructureTreeRoot treeRoot = new PDStructureTreeRoot();
doc.getDocumentCatalog().setMarkInfo(mark);
doc.getDocumentCatalog().setStructureTreeRoot(treeRoot);
doc.getDocumentCatalog().getMarkInfo().setMarked(true);

PDDocumentInformation info = doc.getDocumentInformation();
info.setCreationDate(date);
info.setModificationDate(date);
info.setAuthor("KairosPDF");
info.setProducer("KairosPDF");
info.setCreator("KairosPDF");
info.setTitle("Generated PDf");
info.setSubject("PDF/A3-A");
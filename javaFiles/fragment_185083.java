PDDocument document = PDDocument.loadNonSeq(new File(pdfFilename), null);
List<PDPage> pdPages = document.getDocumentCatalog().getAllPages();
for (PDPage pdPage : pdPages)
{ 
    pdPage.setAnnotations(null);
}
document.save(new File(...));
document.close();
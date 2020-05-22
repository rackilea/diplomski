PDDocumentOutline outline = pdocument.getDocumentCatalog().getDocumentOutline();
PDPageTree pageTree = pdocument.getPages();

for (PDOutlineItem item : outline.children()) {

String pageTitle=item.getTitle(); //Topic 1

PDPage destinationPage=item.findDestinationPage(pdocument);

PDPage currentPage = item.findDestinationPage(pdocument);
int startPg = pageTree.indexOf(currentPage);

PDPage nextIndexPage = item.getNextSibling().findDestinationPage(pdocument);

int endPg = pageTree.indexOf(nextIndexPage);

PDDocument document = new PDDocument();

for (int i = startPg; i < endPg; i++) {

    PDPage incomingPage = pageTree.get(i);

    document.addPage(incomingPage);

    }

document.save(targetPath + item.getTitle() + ".pdf");
document.close();



}
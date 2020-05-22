private static void shiftPdfBookmarksUnderNewBookmark(PdfDocument pdfDocument, String bookmarkLabel) {
if (pdfDocument == null || pdfDocument.getWriter() == null) {
  log.warn("shiftPdfBookmarksUnderNewBookmark(): no writer linked to PDFDocument, cannot modify bookmarks");
  return;
}
pdfDocument.initializeOutlines();
try {
  PdfOutline rootOutline = pdfDocument.getOutlines(false);
  PdfOutline subOutline = rootOutline.addOutline(bookmarkLabel);
  subOutline.addDestination(PdfExplicitDestination.createFit(pdfDocument.getFirstPage())); // Not sure why this is needed, but problems if omitted.
  List<PdfOutline> pdfOutlineChildren = rootOutline.getAllChildren();
  if (pdfOutlineChildren.size() == 1) {
    return;
  }
  int i = 0;
  for (PdfOutline p : rootOutline.getAllChildren()) {
    if (p != subOutline) {
      if (p.getDestination() == null) {
        continue;
      }
      subOutline.addOutline(p);
    }
  }
  rootOutline.getAllChildren().clear();
  rootOutline.addOutline(subOutline);
  subOutline.addDestination(PdfExplicitDestination.createFit(pdfDocument.getFirstPage())); // not sure why duplicate line above seems to be needed
}
catch (Exception logAndIgnore) {
  log.warn("shiftPdfBookmarksUnderNewBookmark ignoring error and not shifting bookmarks: " +logAndIgnore, logAndIgnore);
}
}
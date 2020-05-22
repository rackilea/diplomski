File documentFile = new File(SOURCE);
File signedDocumentFile = new File(RESULT);

Rectangle2D boundingBox;
PDRectangle mediaBox;
try (   PDDocument document = PDDocument.load(documentFile) ) {
    PDPage pdPage = document.getPage(0);
    BoundingBoxFinder boundingBoxFinder = new BoundingBoxFinder(pdPage);
    boundingBoxFinder.processPage(pdPage);
    boundingBox = boundingBoxFinder.getBoundingBox();
    mediaBox = pdPage.getMediaBox();
}

CreateVisibleSignature signing = new CreateVisibleSignature(ks, PASSWORD.clone());
try (   InputStream imageStream = IMAGE_STREAM) {
    signing.setVisibleSignDesigner(documentFile.getPath(), (int)boundingBox.getX(), (int)(mediaBox.getUpperRightY() - boundingBox.getY()), -50, imageStream, 1);
}
signing.setVisibleSignatureProperties("name", "location", "Security", 0, 1, true);
signing.setExternalSigning(false);
signing.signPDF(documentFile, signedDocumentFile, null);
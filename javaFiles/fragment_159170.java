// initialize

PdfSmartCopy pdfSmartCopy = new PdfSmartCopy(document, memoryStream);
for (int i = debut; i < fin; i++) {
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    // fill in the form here

    stamper.close();    
    PdfReader reader = new PdfReader(out.toByteArray());
    reader.consolidateNamedDestinations();
    PdfImportedPage pdfImportedPage = pdfSmartCopy.getImportedPage(reader, 1);
    pdfSmartCopy.addPage(pdfImportedPage);

    // other actions ...
}
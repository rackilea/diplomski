try (   InputStream resource = PDF_SOURCE_STREAM;
        OutputStream result = PDF_TARGET_STREAM;
        PDDocument pdDocument = PDDocument.load(resource)   )
{
    PDAcroForm acroForm = pdDocument.getDocumentCatalog().getAcroForm();
    if (acroForm == null) {
        pdDocument.getDocumentCatalog().setAcroForm(acroForm = new PDAcroForm(pdDocument));
    }
    acroForm.setSignaturesExist(true);
    acroForm.setAppendOnly(true);
    acroForm.getCOSObject().setDirect(true);

    PDRectangle rectangle = new PDRectangle(100, 600, 300, 100);
    PDSignature signature = new PDSignature();
    signature.setFilter(PDSignature.FILTER_ADOBE_PPKLITE);
    signature.setSubFilter(PDSignature.SUBFILTER_ADBE_PKCS7_DETACHED);
    signature.setName("Example User");
    signature.setLocation("Los Angeles, CA");
    signature.setReason("Testing");
    signature.setSignDate(Calendar.getInstance());
    pdDocument.addSignature(signature, this);

    for (PDPage pdPage : pdDocument.getPages()) {
        addSignatureField(pdDocument, pdPage, rectangle, signature);
    }

    pdDocument.saveIncremental(result);
}
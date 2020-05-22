void addSignatureField(PDDocument pdDocument, PDPage pdPage, PDRectangle rectangle, PDSignature signature) throws IOException {
    PDAcroForm acroForm = pdDocument.getDocumentCatalog().getAcroForm();
    List<PDField> acroFormFields = acroForm.getFields();

    PDSignatureField signatureField = new PDSignatureField(acroForm);
    signatureField.setSignature(signature);
    PDAnnotationWidget widget = signatureField.getWidgets().get(0);
    acroFormFields.add(signatureField);

    widget.setRectangle(rectangle);
    widget.setPage(pdPage);

    // from PDVisualSigBuilder.createHolderForm()
    PDStream stream = new PDStream(pdDocument);
    PDFormXObject form = new PDFormXObject(stream);
    PDResources res = new PDResources();
    form.setResources(res);
    form.setFormType(1);
    PDRectangle bbox = new PDRectangle(rectangle.getWidth(), rectangle.getHeight());
    float height = bbox.getHeight();

    form.setBBox(bbox);
    PDFont font = PDType1Font.HELVETICA_BOLD;

    // from PDVisualSigBuilder.createAppearanceDictionary()
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    appearance.getCOSObject().setDirect(true);
    PDAppearanceStream appearanceStream = new PDAppearanceStream(form.getCOSObject());
    appearance.setNormalAppearance(appearanceStream);
    widget.setAppearance(appearance);

    try (PDPageContentStream cs = new PDPageContentStream(pdDocument, appearanceStream))
    {
        // show background (just for debugging, to see the rect size + position)
        cs.setNonStrokingColor(Color.yellow);
        cs.addRect(-5000, -5000, 10000, 10000);
        cs.fill();

        float fontSize = 10;
        float leading = fontSize * 1.5f;
        cs.beginText();
        cs.setFont(font, fontSize);
        cs.setNonStrokingColor(Color.black);
        cs.newLineAtOffset(fontSize, height - leading);
        cs.setLeading(leading);
        cs.showText("Signature text");
        cs.newLine();
        cs.showText("some additional Information");
        cs.newLine();
        cs.showText("let's keep talking");
        cs.endText();
    }

    pdPage.getAnnotations().add(widget);

    COSDictionary pageTreeObject = pdPage.getCOSObject(); 
    while (pageTreeObject != null) {
        pageTreeObject.setNeedToBeUpdated(true);
        pageTreeObject = (COSDictionary) pageTreeObject.getDictionaryObject(COSName.PARENT);
    }
}
File acroFormTemplate = new File("someTemplate.pdf");
Map<String, String> someMapOfFieldToValues = new HashMap<>();
try (
    PdfDocument  finalOutput = new PdfDocument(new PdfWriter(new FileOutputStream(new File("finalOutput.pdf")));
) {
    for (/* some looping condition */int x = 0; x < 5; x++) {
        // for each iteration of the loop, create a temporary in-memory
        // PDF to handle form field edits.
        ByteArrayOutputStream tmp = new ByteArrayOutputStream();
        try (
            PdfDocument filledInAcroFormTemplate = new PdfDocument(new PdfReader(new FileInputStream(acroFormTemplate)), new PdfWriter(tmp));
        ) {
            PdfAcroForm acroForm = PdfAcroForm.getAcroForm(filledInAcroFormTemplate, true);
            for (PdfFormField field : acroForm.getFormFields().values()) {
                if (someMapOfFieldToValues.containsKey(field.getFieldName())) {
                    field.setValue(someMapOfFieldToValues.get(field.getFieldName()));
                }
            }
            // NOTE that because we're adding the template multiple times
            // we need to adopt a field renaming strategy to ensure field
            // uniqueness in the final document.  For demonstration's sake
            // we'll just rename them prefixed w/ our loop counter
            List<String> fieldNames = new ArrayList<>();
            fieldNames.addAll(acroForm.getFormFields().keySet()); // avoid ConfurrentModification
            for (String fieldName : fieldNames) {
                acroForm.renameField(fieldName, x+"_"+fieldName);
            }
        }

        // the temp PDF needs to be "closed" for all the PDF finalization
        // magic to happen...so open up new read-only version to act as
        // the source for the merging from our in-memory bucket-o-bytes
        try (
            PdfDocument readOnlyFilledInAcroFormTemplate = new PdfDocument(new PdfReader(new ByteArrayInputStream(tmp.toByteArray())));
        ) {
            // although PdfPage.copyTo will probably work for simple pages, PdfDocument.copyPagesTo
            // is a more comprehensive copy (wider support for copying Outlines and Tagged content)
            // so it's more suitable for general page-copy use.  Also, since we're copying AcroForm
            // content, we need to use the PdfPageFormCopier
            readOnlyFilledInAcroFormTemplate.copyPagesTo(1, 1, finalOutput, new PdfPageFormCopier());
        }
    }
}
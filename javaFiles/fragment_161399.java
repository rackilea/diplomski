// Load the pdfTemplate
    pdfTemplate = PDDocument.load(file);

    PDDocumentCatalog docCatalog = pdfTemplate.getDocumentCatalog();
    PDAcroForm acroForm = docCatalog.getAcroForm();

    // Get field names
    List<PDField> fieldList = acroForm.getFields();

    // String the object array
    String[] fieldArray = new String[fieldList.size()];
    int i = 0;
    for (PDField sField : fieldList) {
        fieldArray[i] = sField.getFullyQualifiedName();
        i++;
    }

    // Loop through each field in the array and do something
    for (String f : fieldArray) {
        PDField field = acroForm.getField(f);

        System.out.println("f is: " + f);
        if (f.contains("EXAMPLE FORM FIELD NAME")) {
            DO SOMETHING
                            String value = "example value";
            field.setValue(value);
            System.out.println("printed: " + value + " to: " + f);
        }
    }

    // Save edited file
    pdfTemplate.save(sPdfTemplate);
    pdfTemplate.close();
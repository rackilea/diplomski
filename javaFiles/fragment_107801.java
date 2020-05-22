PdfReader reader = new PdfReader(MY_FILE);
    OutputStream os = new FileOutputStream(PATH_HERE);
    PdfStamper stamper = new PdfStamper(reader, os);

    AcroFields acroFields = stamper.getAcroFields();
    acroFields.setField("aAddressLine1", "ADDRESS1_HERE");
    acroFields.setField("aAddressLine2", "ADDRESS1_HERE");
    stamper.close();
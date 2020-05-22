FileOutputStream mergeOutStream = new FileOutputStream(new File("C:\\UpdateFile\\mergepath\\updatetem.pdf")); //To update user content to Template

    PdfReader reader = new PdfReader(new FileInputStream(new File("C:\\UpdateFile\\template\\template.pdf"))); //Template File Stream
    PdfStamper stamper = new PdfStamper(reader, mergeOutStream);

    stamper.setFormFlattening(false);
    AcroFields form = stamper.getAcroFields();

    Map<String, Item> fieldMap = form.getFields();

    for (String key : fieldMap.keySet()) {
        String fieldValue = dataMap.get(key);
        if (fieldValue != null) {
            form.setField(key, fieldValue);
        }
    }
    stamper.close();
public void manipulatePdf(String src, String dest) throws DocumentException, IOException {
    Document document = new Document();
    PdfCopy copy = new PdfSmartCopy(document, new FileOutputStream(dest));
    document.open();
    ByteArrayOutputStream baos;
    PdfReader reader;
    PdfStamper stamper;
    AcroFields fields;
    StringTokenizer tokenizer;
    BufferedReader br = new BufferedReader(new FileReader(DATA));
    String line = br.readLine();
    while ((line = br.readLine()) != null) {
        // create a PDF in memory
        baos = new ByteArrayOutputStream();
        reader = new PdfReader(SRC);
        stamper = new PdfStamper(reader, baos);
        fields = stamper.getAcroFields();
        tokenizer = new StringTokenizer(line, ";");
        fields.setField("name", tokenizer.nextToken());
        fields.setField("abbr", tokenizer.nextToken());
        fields.setField("capital", tokenizer.nextToken());
        fields.setField("city", tokenizer.nextToken());
        fields.setField("population", tokenizer.nextToken());
        fields.setField("surface", tokenizer.nextToken());
        fields.setField("timezone1", tokenizer.nextToken());
        fields.setField("timezone2", tokenizer.nextToken());
        fields.setField("dst", tokenizer.nextToken());
        stamper.setFormFlattening(true);
        stamper.close();
        reader.close();
        // add the PDF to PdfCopy
        reader = new PdfReader(baos.toByteArray());
        copy.addDocument(reader);
        reader.close();
    }
    br.close();
    document.close();
}
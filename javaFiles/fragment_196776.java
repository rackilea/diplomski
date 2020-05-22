public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
    Document document = new Document();
    PdfCopy copy = new PdfSmartCopy(document, new FileOutputStream(dest));
    copy.setMergeFields();
    document.open();
    List<PdfReader> readers = new ArrayList<PdfReader>();
    for (int i = 0; i < 3; ) {
        PdfReader reader = new PdfReader(renameFields(src, ++i));
        readers.add(reader);
        copy.addDocument(reader);
    }
    document.close();
    for (PdfReader reader : readers) {
        reader.close();
    }
}

public byte[] renameFields(String src, int i) throws IOException, DocumentException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PdfReader reader = new PdfReader(src);
    PdfStamper stamper = new PdfStamper(reader, baos);
    AcroFields form = stamper.getAcroFields();
    Set<String> keys = new HashSet<String>(form.getFields().keySet());
    for (String key : keys) {
        form.renameField(key, String.format("%s_%d", key, i));
    }
    stamper.close();
    reader.close();
    return baos.toByteArray();
}
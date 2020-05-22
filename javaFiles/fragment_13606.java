public static void scanFields(String path) throws IOException {
    PdfReader pdfReader = new PdfReader(path);
    AcroFields acroFields = pdfReader.getAcroFields();
    HashMap<String,AcroFields.Item> fields = acroFields.getFields();
    Set<Entry<String, Item>> entrySet = fields.entrySet();
    for (Entry<String, Item> entry : entrySet) {
        String key = entry.getKey();
    }
}
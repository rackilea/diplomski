try (   PdfReader reader = new PdfReader(...);
        PdfWriter writer = new PdfWriter(...);
        PdfDocument document = new PdfDocument(reader, writer)) {
    PdfCollection collection = new PdfCollection();
    document.getCatalog().setCollection(collection);
    PdfCollectionSchema schema = new PdfCollectionSchema();
    PdfCollectionField field = new PdfCollectionField("File Name", PdfCollectionField.FILENAME);
    field.setOrder(0);
    schema.addField("Name", field);
    field = new PdfCollectionField("Modification Date", PdfCollectionField.MODDATE);
    field.setOrder(1);
    schema.addField("Modified", field);
    collection.setSchema(schema);
    PdfCollectionSort sort = new PdfCollectionSort("Modified");
    collection.setSort(sort);
}
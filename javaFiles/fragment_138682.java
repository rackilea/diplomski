Document doc = new Document();
doc.add(new Field("DOC_ID", "DOCONE", new FieldType(
            TextField.TYPE_STORED)));
doc.add(new Field("TEXT_FIELD", "This", new FieldType(
            TextField.TYPE_NOT_STORED)));
writer.addDocument(doc);
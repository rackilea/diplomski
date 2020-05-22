Document doc = new Document();
Field field1 = new TextField("field1", field1Value, Field.Store.YES);
doc.add(field1);
Field field2 = new StringField("field2", field2Value,Field.Store.YES);
doc.add(field2);
while ((line = br.readLine()) != null) {
    field1.setStringValue("field1Value");
    field2.setStringValue("field2Value");

    writer.addDocument(doc);
}
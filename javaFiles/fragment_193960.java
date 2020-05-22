public void updateField(String docId, int newFieldvalue) {
    MyDataObject data = primaryDataStore.fetch(docId);
    data.setFieldValue(newFieldValue);
    primaryDataStore.save(data);
    updateIndex(data);
}

public void updateIndex(MyDataObject object) {
    // convertToLucene is more or less the code in the
    // first snippet of your question 
    Document d = convertToLucene(object);
    // IndexWriter should be created once
    // IndexWriter.updateDocument will internally delete and index 
    // the document
    this.writer.updateDocument(new Term("id", object.getId()), d);
    // potentially call writer.commit()
}
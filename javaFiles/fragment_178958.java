int maxdoc = reader.maxDoc();
Bits liveDocs = MultiFields.getLiveDocs(reader);
for (int i = 0; i < maxdoc; i++) {
    if (!liveDocs.get(docID)) continue;
    Document doc = reader.document(i);
    String idDoc = doc.get("doc_id");
    ....
}
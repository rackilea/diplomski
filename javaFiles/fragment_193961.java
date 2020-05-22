public MyDataObject fetchFromLucene(String docId) {
     IndexSearcher searcher = getSearcher();
     TopDocs docs = searcher.search(new TermQuery(new Term("id", docId)), 1);
     if (docs.totalHits > 0) {
         Document d = searcher.document(docs.scoreDocs[0].doc);
         // "document_data" is a binary field you'll have to add
         // on every lucene docs where you put a serialized version
         // of your domain object.
         return deserialize( d.getBinaryValue("document_data") );
     }
     return null;
}

public MyDataObject deserialize(ByteRef data) {
    // a method to deserialize binary data into MyDataObject
    return deserializedData;
}
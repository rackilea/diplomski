public static void main(String[] args) throws IOException, ParseException {
    IndexWriter luceneIndexWriter = new IndexWriter(
            FSDirectory.open(new File("/tmp/test")), createWriterConfig(64));
    Document doc1 = createDocument(ID1, "context1", 1);
    luceneIndexWriter.addDocument(doc1);
    Document doc2 = createDocument(ID2, "context2", 2);
    luceneIndexWriter.addDocument(doc2);

    System.out.println("Found doc1: "
            + findDocument(ID1, 1, luceneIndexWriter));
    System.out.println("Found doc2: "
            + findDocument(ID2, 2, luceneIndexWriter));
    doc1 = findDocument(ID1, 1, luceneIndexWriter);

    // Section 1
    doc1.removeField(CONTEXT_FIELD);
    doc1.add(new TextField(CONTEXT_FIELD, "context1_changed",
            Field.Store.YES));

    //re-adding the IntField here
    Number num = doc1.getField(NUMBER_OF_ARGUMENTS).numericValue();
    doc1.removeField(NUMBER_OF_ARGUMENTS);
    doc1.add(new IntField(NUMBER_OF_ARGUMENTS, num.intValue(),
            Field.Store.YES));

    luceneIndexWriter.updateDocument(new Term(METHOD_NAME_FIELD, "text"),
            doc1);

    System.out.println("Found doc1: "
            + findDocument(ID1, 1, luceneIndexWriter));
    System.out.println("Found doc2: "
            + findDocument(ID2, 2, luceneIndexWriter));

    // Section 2
    doc1 = findDocument(ID1, 1, luceneIndexWriter);
    doc1.removeField(CONTEXT_FIELD);
    doc1.add(new TextField(CONTEXT_FIELD, "context1_changed2",
            Field.Store.YES));
    luceneIndexWriter.updateDocument(new Term(METHOD_NAME_FIELD, "text"),
            doc1);
    num = doc1.getField(NUMBER_OF_ARGUMENTS).numericValue();
    doc1.removeField(NUMBER_OF_ARGUMENTS);
    doc1.add(new IntField(NUMBER_OF_ARGUMENTS, num.intValue(),
            Field.Store.YES));
    luceneIndexWriter.updateDocument(new Term(METHOD_NAME_FIELD, "text"),
            doc1);

    System.out.println("Found doc1: "
            + findDocument(ID1, 1, luceneIndexWriter));
    System.out.println("Found doc2: "
            + findDocument(ID2, 2, luceneIndexWriter));

    luceneIndexWriter.close();
}
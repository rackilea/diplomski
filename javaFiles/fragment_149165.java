public static void outputTheWholeThing(IndexWriter writer) throws IOException {
    DirectoryReader reader = DirectoryReader.open(writer, true);
    for (int i=0; i<reader.maxDoc(); i++) {
        Document doc = reader.document(i);
        System.out.println(doc);
    }
    System.out.println("Pending deletions:" + reader.numDeletedDocs());
}
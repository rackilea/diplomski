while (scanner.hasNextLine()) {
    String word= scanner.next();

    if (collection.count(Filters.eq("word", word)) == 0L) {
        Document document = new Document();
        document.put("word", word);

        collection.insertOne(document);
    }
}
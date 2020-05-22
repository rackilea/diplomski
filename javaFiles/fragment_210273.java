JavaRDD<Document> documents = jsc.parallelize(asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)).map
        (new Function<Integer, Document>() {
    @Override
    public Document call(final Integer i) throws Exception {
        return Document.parse("{test: " + i + "}");
    }
});

MongoSpark.save(documents);
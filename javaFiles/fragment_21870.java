Stream<YourData> readData(...) {
    final MongoIterable<YourData> rs = myCollection.find(...)
            .projection(fields(...))
            .map(x -> new YourData(x));
    return StreamSupport.stream(rs.spliterator(), false);
}
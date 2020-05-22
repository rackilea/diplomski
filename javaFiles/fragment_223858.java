...
StringTerms subjects = aggregations.asMap().get("subjects");
for (Terms.Bucket bucket : subjects.getBuckets()) {
    String key = bucket.getKey();
    long docCount = bucket.getDocCount();
    // do something with the key and the doc count
}
@Test
public void shouldBeAbleToQueryBetweenTwoDates() throws Exception {
    // setup
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");

    MongoTemplate mongoTemplate = new MongoTemplate(new Mongo(), "TheDatabase");
    DBCollection collection = mongoTemplate.getCollection("myObject");
    // cleanup
    collection.drop();

    // date that should match
    Date expectedDate = dateFormat.parse("2013-06-12T00:00:00Z");
    collection.insert(new BasicDBObject("cd", expectedDate));
    // date that should not match (it's last year)
    collection.insert(new BasicDBObject("cd", dateFormat.parse("2012-06-12T00:00:00Z")));

    // create and execute the query
    final Date to = dateFormat.parse("2013-06-30T09:12:29Z");
    final Date from = dateFormat.parse("2013-06-11T09:12:29Z");

    Query query = new Query();
    query.addCriteria(Criteria.where("cd").gte(from).lte(to));

    // check it returned what we expected
    List<MyObject> basicDBObjects = mongoTemplate.find(query, MyObject.class);
    Assert.assertEquals(1, basicDBObjects.size());
    Assert.assertEquals(expectedDate, basicDBObjects.get(0).cd);
}
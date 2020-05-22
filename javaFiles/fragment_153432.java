class CustomPostRepositoryImpl implements CustomPostRepository {

    @Autowired
    private MongoOperations mongoOperations;

    public List<Post> yourCustomMethod() {

      // custom match queries here
      MatchOperation match = null;
      // Group by , Lookup others stuff goes here
      // For details: https://docs.spring.io/spring-data/mongodb/docs/current/api/org/springframework/data/mongodb/core/aggregation/Aggregation.html

      Aggregation aggregate = Aggregation.newAggregation(match);

      AggregationResults<Post> orderAggregate = mongoOperations.aggregate(aggregate,
                      Post.class, Post.class);
      return orderAggregate.getMappedResults();

    }
}
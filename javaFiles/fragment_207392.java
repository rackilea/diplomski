@Autowired
private MongoOperations mongoOperations;

...

public List<Person> findByAddressZipCode(int zip) {

    List<AggregationOperation> list = new ArrayList<AggregationOperation>();
    list.add(Aggregation.unwind("address"));
    list.add(Aggregation.match(Criteria.where("address.zip").is(zip)));
    list.add(Aggregation.group("firstName", "lastName").push("address").as("address"));
    list.add(Aggregation.project("firstName", "lastName", "address"));
    TypedAggregation<Person> agg = Aggregation.newAggregation(Person.class, list);
    return mongoOperations.aggregate(agg, Person.class, Person.class).getMappedResults();
}
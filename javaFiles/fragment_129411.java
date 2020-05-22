private AggregateTestFixture<MyAggregate> aggregateTestFixture;

@Autowired
private MyAggregateDao myDao;

@BeforeEach
void beforeEach () {

    aggregateTestFixture = new AggregateTestFixture<>(MyAggregate.class);

    // We still need to register resources manually
    aggregateTestFixture.registerInjectableResource(myDao);

}
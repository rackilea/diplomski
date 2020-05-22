@Test
void creationSucceeds () {

    aggregateTestFixture = new AggregateTestFixture<>(MyAggregate.class);
    aggregateTestFixture.registerInjectableResource(
          Mockito.mock(MyAggregateDao.class));

}
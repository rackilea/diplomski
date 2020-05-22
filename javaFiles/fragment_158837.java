@Test
public void mockTest() {

    final Collection<String> collection = Mockito.mock(Collection.class);

    collection.addAll(Lists.newArrayList("hello"));

    Mockito.verify(collection).addAll((Collection<? extends String>) MockitoHamcrest.argThat(Matchers.contains("hello")));
}
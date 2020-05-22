@Test
public void testUnwrapping() throws IOException {
    String json = "{\"customers\":[{\"email\":\"hello@world.com\"},{\"email\":\"john.doe@example.com\"}]}";
    ObjectReader objectReader = mapper.reader(new TypeReference<List<Customer>>() {})
                                      .withRootName("customers");
    List<Customer> customers = objectReader.readValue(json);
    assertThat(customers, contains(customer("hello@world.com"), customer("john.doe@example.com")));
}
@Test
public void testUnmarshal() throws Exception {
    mockEndResult.expectedMessageCount(1);

    template.sendBody("direct:teststart", new File("src/test/resources/test.txt"));

    mockEndResult.assertIsSatisfied();

    @SuppressWarnings("unchecked")
    List<Customer> customers = mockEndResult.getExchanges().get(0).getIn().getBody(List.class);
    assertEquals(customers.get(0).toString(), "F1:::L1");
    assertEquals(customers.get(1).toString(), "F2:::L2");
    assertEquals(customers.get(2).toString(), "F3:::L3");
}
@Test
public void testUnmarshal() throws Exception {
    mockEndResult.expectedMessageCount(1);

    write2File.expectedBodiesReceived("F1:::L1", "F3:::L3", "F2:::L2");
    template.sendBody("direct:teststart", new File("src/test/resources/test.txt"));
    mockEndResult.assertIsSatisfied();

    Customer resultCustomer = processActs.getExchanges().get(0).getIn().getBody(Customer.class); 
    assertEquals(resultCustomer.toString(),"F1:::L1"); 
}
@Test
public void testReceiveListOfStrings() throws Exception {
    WebResource webResource = resource();
    ClientResponse responseMsg = webResource.path("/v1/test/receiveListOfStrings")
            .queryParam("list", "one")
            .queryParam("list", "two")
            .queryParam("list", "three")
            .get(ClientResponse.class);
    Assert.assertEquals(200, responseMsg.getStatus());
}
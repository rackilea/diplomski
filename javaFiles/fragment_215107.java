@Test
public void testInitializeWithGoodInput() {
    DataStoreService mockDataStoreService = mock(DataStoreService.class);
    MyRestService service = new MyRestService(mockDataStoreService);
    String goodInput = "...";
    Response response = service.initialize(goodInput);
    assertEquals(Response.Status.OK, response.getStatus());

    ArgumentCaptor<Entity> argument = ArgumentCaptor.forClass(Entity.class);
    verify(mock).put(argument.capture());
    assertEquals("the correct kind", argument.getValue().getKind());
    // ... other assertions
}
@Mock
Client client;

@Mock
WebResource webResource;

@Mock
WebResource.Builder builder;


@Test
public void test() {
ReflectionTestUtils.setField(payeezyHandler,"webServiceClient",client);
Mockito.when(client.resource(anyString())).thenReturn(webResource);
Mockito.when(webResource.getRequestBuilder()).thenReturn(builder);

Mockito.when(builder.type(MediaType.APPLICATION_JSON_TYPE)).thenReturn(builder);
Mockito.when(builder.accept(MediaType.APPLICATION_JSON_TYPE)).thenReturn(builder);
Mockito.when(builder.post(Matchers.eq(String.class),anyString())).thenReturn(fakeResponse());
}
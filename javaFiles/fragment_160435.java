final Response response = Response.ok().build();

IClient inner = new IClient(client, propConfig){
  Builder buildRequest(MultivaluedMap<String, Object> Headers, WebTarget target){
    Builder builder = mock(Builder.class);
    when(builder.post(any(Entity.class)).thenReturn(response)
    return builder;
  }
};

assertNotNull(inner.doLogin());
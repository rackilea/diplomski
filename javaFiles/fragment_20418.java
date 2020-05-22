Mockito.doAnswer(new Answer<CloseableHttpResponse>() {
  @Override
  public CloseableHttpResponse answer(InvocationOnMock invocation) {
    CloseableHttpResponse httpResponse = Mockito.mock(CloseableHttpResponse.class);

    // No change to status code based on endpoints
    Mockito.when(status.getStatusCode()).thenReturn(withResponseCode);
    Mockito.when(httpResponse.getStatusLine()).thenReturn(status);

    HttpEntity entity = Mockito.mock(HttpEntity.class);
    Object[] args = invocation.getArguments();
    String endpoint = ((HttpPost) args[0]).getURI().getPath();
    if (endpoint.contains("/a/b")) {
      entity = EntityBuilder.create().setText("something").build();
      Mockito.when(httpResponse.getEntity()).thenReturn(entity);
    } else {
      entity = EntityBuilder.create().setText("something else").build();
      Mockito.when(httpResponse.getEntity()).thenReturn(entity);
    }
    return httpResponse;
  }
}).when(client).execute(Mockito.any(HttpUriRequest.class));
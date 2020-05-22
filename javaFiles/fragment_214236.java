Mockito.when(mockResource.contentType(Mockito.anyString()))
    .thenReturn(mockResource);
Mockito.when(mockResource.accept(Mockito.anyString()))
    .thenReturn(mockResource);
Mockito.when(mockResource.get(Mockito.eq(String.class))) // or any(Class.class)
    .thenReturn("dummy read response");
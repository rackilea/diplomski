when(dataProvider
    .provide(any(Request.class)))
    .thenAnswer((Answer<Response>) invocation -> {
        Thread.sleep(FOREVER);
        return response;
    });
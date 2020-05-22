TestRoute route = new TestRoute();

IRouteHandlerRegistry registry = mock(IRouteHandlerRegistry.class);
IHandleRoute<TestRoute> handler = mock(IHandleRoute.class);

when(registry.getHandlerFor(route)).thenReturn(handler);
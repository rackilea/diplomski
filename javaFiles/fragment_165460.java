MyService service = Mockito.mock(MyService.class);
when(service.getObject()).thenReturn(new Object());

HttpHeaders headers = Mockito.mock(HttpHeaders.class);
when(headers.getHeaderString("X-Header")).thenReturn("blah");

UriInfo uriInfo = Mockito.mock(UriInfo.class);
when(uriInfo.getRequestUri()).thenReturn(URI.create("http://localhost"));
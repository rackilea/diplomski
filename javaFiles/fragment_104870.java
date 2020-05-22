WebResource service = client.resource(uri);

WebResource serviceSpy = Mockito.spy(service);

Mockito.doThrow(new RuntimeException("500!")).when(serviceSpy).get(Mockito.any(String.class));

serviceSpy.path("rest").path("somePath")
            .accept(MediaType.TEXT_HTML).get(String.class);
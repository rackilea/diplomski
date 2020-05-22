JasperserverRestClient jasperServerClient = Mockito.mock( JasperserverRestClient.class );
RestClientSession session = Mockito.mock( RestClientSession.class );

Mockito.when( jasperServerClient.authenticate( "x", "y")).thenReturn( session );

RepositoryClient repositoryClient = new RepositoryClient(jasperServerClient);
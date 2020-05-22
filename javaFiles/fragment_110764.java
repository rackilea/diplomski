@Mock
private RestTemplate restTemplate;

@InjectMock                                            // Injects all necessary @Mock objects
private AuthorizeClient authorizeClient;               // An implementation, not an interface

@Test
public void testAuthorizationPermissions()  {

    Mockito.when(restTemplate.postForEntity(Mockito.anyString(), Mockito.any(), Mockito.any()))
           .thenReturn(expGrantedPermissions);

    // now it is assured the authorizeClient uses restTemplate and not its own one

    var res = authorizeClient.getAllGrantedPermissions(permissionsRequest);
    assertNotNull(res);

}
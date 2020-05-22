@Mock
  AmazonHttpClient client;
  @Mock
  ExecutionContext executionContext;
  @Mock
  HttpResponseHandler<AmazonClientException> handler;
  @Mock    
  HttpResponseHandler<String> responseHandler;

  // For request, you can create a custom one or use mock data
  Request<?> request;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    // other setups
  }

  @Test
  public void getStringResponseTest() {
    // you can test now
    yourCall.getStringResponse(request, client, executionContext, handler, responseHandler);
    // verify whatever you want....
  }
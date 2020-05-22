@Autowired
private RestTemplate restTemplate;

private MockRestServiceServer mockServer;

@Before
public void setup() {
    this.mockServer = MockRestServiceServer.createServer(this.restTemplate);
}

@Test
public void testDefaultMethod() throws Exception {
    this.mockServer.expect(requestTo("/testApps/httpMethod"))
            .andExpect(method(HttpMethod.POST))
            .andRespond(withSuccess(HttpMethod.POST.name(), MediaType.TEXT_PLAIN));

    this.defaultChannel.send(new GenericMessage<String>("Hello"));
    Message<?> message = this.replyChannel.receive(5000);
    assertNotNull(message);
    assertEquals("POST", message.getPayload());

    this.mockServer.verify();
}
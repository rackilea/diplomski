@RunWith(CamelSpringBootRunner.class)
@SpringBootTest
@MockEndpoints
public class MyRouteTest2 {

  @Autowired
  private ProducerTemplate producerTemplate;

  @EndpointInject(uri = "mock:file:out")
  private MockEndpoint mockCamel;

  @Test
  public void test() throws InterruptedException {
    String body = "Camel";
    mockCamel.expectedMessageCount(1);

    producerTemplate.sendBody("file:in", body);

    mockCamel.assertIsSatisfied();
  }
}
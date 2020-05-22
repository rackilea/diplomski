@AutoConfigureWebTestClient
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(
    classes={
            server_spring.Application.class,
            server_spring.config.WebSecurityConfig.class,
            server_spring.config.GlobalConfiguration.class,
            server_spring.config.MvcConfig.class,
            server_spring.config.WebConfig.class
    })
public class UserControllerImplTest {
    @Autowired
    private WebTestClient webClient;

    @Test
    public void testWithAnotherMethod() {
        Map<String, String> jsonMap = new HashMap();
        jsonMap.put("email","martinbryan.eu@gmail.com");
        jsonMap.put("password","groschat93**");

        webClient
            .post()
            .uri("/api/users/authenticate")
            .header("Origin","https://front.dev")
            .header("Referer","https://front.dev")
            .header("Host", "back-spring.dev")
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromObject(jsonMap))
            .exchange()
            .expectStatus()
            .isOk();
    }
}
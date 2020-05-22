@RunWith(SpringJUnit4ClassRunner.class)
public class ServicesIntegrationTest {

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void runTest() throws Exception {
        SpringApplicationBuilder uws = new SpringApplicationBuilder(UserWebApplication.class)
                .properties("server.port=8081",
                        "server.contextPath=/UserService",
                        "SOA.ControllerFactory.enforceProxyCreation=true");
        uws.run();

        SpringApplicationBuilder pws = new SpringApplicationBuilder(ProjectWebApplication.class)
                .properties("server.port=8082",
                        "server.contextPath=/ProjectService",
                        "SOA.ControllerFactory.enforceProxyCreation=true");
        pws.run();

        String url = "http://localhost:8081/UserService/users";
        ResponseEntity<SimplePage<UserDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<SimplePage<UserDTO>>() {
                });
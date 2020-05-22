@Before
public void setup() {
    RestAssuredMockMvc.webAppContextSetup(webAppContext);
    RestAssuredMockMvc.enableLoggingOfRequestAndResponseIfValidationFails();
    Authentication user = customAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken("admin", "123"));
    RestAssuredMockMvc.authentication(user); //add this
    SecurityContextHolder.getContext().setAuthentication(user);
}


@Test
public void makeSureLoginIsOk() {
    RestAssuredMockMvc.get("/myurl").then().statusCode(200); //change given to RestAssured
}
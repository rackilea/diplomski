@Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(projectController)
                .setMessageConverters(new MappingJackson2HttpMessageConverter())
                .setControllerAdvice(new ExceptionControllerAdvice()).build();
}


@SuppressWarnings("unchecked")
@Test
    public void testControllerUserNotFoundException() throws Exception {
        Response resp = new Response();
        resp.setStatusCode(StatusCode.UserNotFoundErrorCode);
        when(fooService.login(any(String.class)).
        thenThrow(UserNotFoundException.class);
        mockMvc.perform(post("/service-user/1.0/auth/login?&username=test")
                        .contentType(contentType)).
     andExpect(status().isNotAcceptable())
                .andExpect(jsonPath("$.statusCode", is("ERRORCODE144")));
}
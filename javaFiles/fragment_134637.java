@Before
public void setup() {
  mockMvc = MockMvcBuilders.webAppContextSetup(context)
    .apply(springSecurity(new MockSpringSecurityFilter()))
    .build();
}

@Test
  public void test(){
    mockMvc.perform(get(...)
     .principal(new UsernamePasswordAuthenticationToken(new CustomUser(), null))...
  }
@WebMvcTest(SimpleController.class)
@Import(AuthenticationManagerProvider.class)
class SimpleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockOAuth2Scope(token = "123456789",
            authorities = "CAN_READ")
    public void test() throws Exception {
        mockMvc.perform(get("/whoami")
                .header("Authorization", "Bearer 123456789"))
                .andExpect(status().isOk())
                .andExpect(content().string("username"));
    }
}
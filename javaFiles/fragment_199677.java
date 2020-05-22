@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Launcher.class)
@WebAppConfiguration
public class ControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void testCustomExceptionResponse() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/your/uri"))
        .andExpect(MockMvcResultMatchers.status().isInternalServerError())
        .andExpect(MockMvcResultMatchers.content().string("Exception: test whatever exception"));

        assertTrue(true);
    }
}